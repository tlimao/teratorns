package com.teratorns.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.game.GameHud;
import com.teratorns.game.GameRenderer;
import com.teratorns.interaction.Interactor;

public class Table extends GameObject implements Interactor<Rectangle> {
	private int[][] tableState;
	private int[][] auxTable;
	private Array<Array<Vector2>> positionsToExplode;
	private Array<int[]> colorsAndNum;
	private Array<Vector2> activePositions;
	private Color baseColor;
	private Rectangle interactionRect;
	private int size;
	private int columnsAndRows;
	private float padding;
	
	public static int score;
	
	private Array<Array<Title>> tableTitles;
	
	public Table(float x, float y, int size, int columnsAndRows, float titlePadding) {
		super(x, y);
		score = 0;
		width = size;
		height = size;
		this.size = size;
		this.columnsAndRows = columnsAndRows;
		tableState = new int[columnsAndRows][columnsAndRows];
		interactionRect = new Rectangle(x, y, size, size);
		baseColor = new Color(52/255f, 73/255f, 94/255f, 0.5f);
		padding = titlePadding;
		createTable();
	}
	
	private void createTable() {
		tableTitles = new Array<Array<Title>>();
		float titleSize = (size - padding * (columnsAndRows + 1)) / 4.0f; 
		for (int i = 0; i < columnsAndRows; i++) {
			Array<Title> row = new Array<Title>();
			
			for (int j = 0; j < columnsAndRows; j++) {
				tableState[i][j] = (int) (Math.random() * 4);
				row.add(new Title(position.x + padding + j * (titleSize + padding), position.y + padding + i * (titleSize + padding), i, j, titleSize, tableState[i][j]));
			}
			
			tableTitles.add(row);
		}
		
		positionsToExplode = new Array<Array<Vector2>>();
		colorsAndNum = new Array<int[]>();
		activePositions = new Array<Vector2>();
		
		update();
		score = 0;
		GameHud.updateScore();
	}

	@Override
	public boolean isTouched(Rectangle obj) {
		for (Array<Title> row : tableTitles) {
			for (Title t : row)  {
				if (t.isTouched(obj)) {
					Vector2 matrixIdx = t.getMatrixIndex();
					int i = (int) matrixIdx.x;
					int j = (int) matrixIdx.y;
					tableState[i][j] += 1;
					tableTitles.get(i).get(j).setValue(tableState[i][j]);
				}
			}
		}
		
		update();
		
		return false;
	}

	@Override
	public void drawInteractor() {
		GameRenderer.instance.shapeRenderer.begin(ShapeType.Line);
		GameRenderer.instance.shapeRenderer.setColor(Color.CYAN);
		GameRenderer.instance.shapeRenderer.rect(interactionRect.x, interactionRect.y, interactionRect.width, interactionRect.height);
		GameRenderer.instance.shapeRenderer.end();
		
		for (Array<Title> row : tableTitles) {
			for (Title t : row)  {
				t.drawInteractor();
			}
		}
	}

	@Override
	public void update() {
		// Verify Explosion
		boolean flag = true;
		while (flag) {
			flag = false;
			
			for (int i = 0; i < columnsAndRows; i++) {
				for (int j = 0; j < columnsAndRows; j++) {
					if (tableState[i][j] >= 4) {
						flag = true;
						int newValue = (int) (Math.random() * 4);
						tableState[i][j] = newValue;
						
						if (j - 1 >= 0) {
							tableState[i][j-1] += 1;
						}
						if (j + 1 < columnsAndRows) {
							tableState[i][j+1] += 1;
						}	
						if (i + 1 < columnsAndRows) {
							tableState[i+1][j] += 1;
						}
						if (i - 1 >= 0) {
							tableState[i-1][j] += 1;
						}
					}
				}
			}
		}
		
		int I = 0, J = 0;
		// update titleValues
		for (Array<Title> row : tableTitles) {
			J = 0;
			for (Title t : row)  {
				t.setValue(tableState[I][J++]);
			}
			I++;
		}
		
		auxTable = new int[columnsAndRows][columnsAndRows];
		positionsToExplode.clear();
		colorsAndNum.clear();
		
		// Row Phase
		for (int i = 0; i < columnsAndRows; i++) {
			activePositions.clear();
			for (int j = 0; j < columnsAndRows - 2; j++) {
				int p1 = tableState[i][j+0];
				int p2 = tableState[i][j+1];
				int p3 = tableState[i][j+2];
				
				if (p1 == p2 && p2 == p3 && auxTable[i][j+0] == 0 && auxTable[i][j+1] == 0 && auxTable[i][j+2] == 0) {
					auxTable[i][j+0] = 1;
					auxTable[i][j+1] = 1;
					auxTable[i][j+2] = 1;
					
					Array<Vector2> newGroup = new Array<Vector2>();
					newGroup.add(new Vector2(i,j+0));
					newGroup.add(new Vector2(i,j+1));
					newGroup.add(new Vector2(i,j+2));
					
					activePositions.addAll(findActivePositions(i, j+0));
					activePositions.addAll(findActivePositions(i, j+1));
					activePositions.addAll(findActivePositions(i, j+2));
					
					while (activePositions.size > 0) {
						Vector2 e = activePositions.pop();
						
						if (tableState[(int) e.x][(int) e.y] == p1) {
							newGroup.add(e);
							auxTable[(int) e.x][(int) e.y] = 1;
							activePositions.addAll(findActivePositions((int) e.x, (int) e.y));
						}
					}
					
					positionsToExplode.add(newGroup);
					colorsAndNum.add(new int[] {p1, newGroup.size});
				}
			}
		}
		
		// Column Phase
		for (int j = 0; j < columnsAndRows; j++) {
			activePositions.clear();
			for (int i = 0; i < columnsAndRows - 2; i++) {
				int p1 = tableState[i+0][j];
				int p2 = tableState[i+1][j];
				int p3 = tableState[i+2][j];
				
				if (p1 == p2 && p2 == p3 && auxTable[i+0][j] == 0 && auxTable[i+1][j] == 0 && auxTable[i+2][j] == 0) {
					auxTable[i+0][j] = 1;
					auxTable[i+1][j] = 1;
					auxTable[i+2][j] = 1;
					
					Array<Vector2> newGroup = new Array<Vector2>();
					newGroup.add(new Vector2(i+0,j));
					newGroup.add(new Vector2(i+1,j));
					newGroup.add(new Vector2(i+2,j));
					
					activePositions.addAll(findActivePositions(i+0, j));
					activePositions.addAll(findActivePositions(i+1, j));
					activePositions.addAll(findActivePositions(i+2, j));
					
					while (activePositions.size > 0) {
						Vector2 e = activePositions.pop();
						
						if (tableState[(int) e.x][(int) e.y] == p1) {
							newGroup.add(e);
							auxTable[(int) e.x][(int) e.y] = 1;
							activePositions.addAll(findActivePositions((int) e.x, (int) e.y));
						}
					}
					
					positionsToExplode.add(newGroup);
					colorsAndNum.add(new int[] {p1, newGroup.size});
				}
			}
		}

		if (positionsToExplode.size > 0) {
			for (Array<Vector2> group : positionsToExplode)
				for (Vector2 pos : group) {
					int newValue = (int) (Math.random() * 4);
					tableState[(int) pos.x][(int) pos.y] = newValue;
					tableTitles.get((int) pos.x).get((int) pos.y).setValue(newValue);
				}
			
			// Update Score
			for (int[] i : colorsAndNum) {
				score += i[0] * i[1];
			}
			
			GameHud.updateScore();
			
			update();
		}		
	}
	
	private Array<Vector2> findActivePositions(int i, int j) {
		Array<Vector2> activePositions = new Array<Vector2>();
				
		if (j - 1 >= 0) {
			if (auxTable[i][j-1] == 0)
				activePositions.add(new Vector2(i,j-1));
		}
		if (j + 1 < columnsAndRows) {
			if (auxTable[i][j+1] == 0)
				activePositions.add(new Vector2(i,j+1));
		}	
		if (i + 1 < columnsAndRows) {
			if (auxTable[i+1][j] == 0)
				activePositions.add(new Vector2(i+1,j));
		}
		if (i - 1 >= 0) {
			if (auxTable[i-1][j] == 0)
				activePositions.add(new Vector2(i-1,j));
		}
		
		return activePositions;
	}

	@Override
	public void draw() {
		Vector2 pos = getPosition();
		GameRenderer.instance.spriteRenderer.setColor(baseColor);
		GameRenderer.instance.spriteRenderer.draw(AssetsLoader.instance.baseColor, pos.x, pos.y, width, height);
		GameRenderer.instance.spriteRenderer.setColor(Color.WHITE);
		
		for (Array<Title> row : tableTitles) {
			for (Title t : row)  {
				t.draw();
			}
		}
	}
}
