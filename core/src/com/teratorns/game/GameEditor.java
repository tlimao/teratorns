package com.teratorns.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.teratorns.assets.AssestsLoader;
import com.teratorns.game.gui.ButtonFactory;
import com.teratorns.game.gui.ButtonFactory.ButtonColor;
import com.teratorns.gui.BaseButton;
import com.teratorns.gui.BaseContainer;
import com.teratorns.gui.Container.ContainerAlignment;
import com.teratorns.gui.GuiElement;
import com.teratorns.gui.ImageButton;
import com.teratorns.gui.TextArea;
import com.teratorns.gui.TextButton;
import com.teratorns.interaction.ActionListener;
import com.teratorns.interaction.Interactor;
import com.teratorns.objects.Bird;
import com.teratorns.objects.SwarmConstants;

public class GameEditor implements Interactor<Rectangle> {
	
	private Array<GuiElement> guiElements;
	
	private enum EditorStates {CREATE_SWARM, NUM_PARTICLES, PARTICLE_RAIO, PARTICLE_COLOR, SWARM_AIM, START, KILL};
	
	private GameWorld gameWorld;
	
	private String action;
	
	private boolean flag;
	
	private float raio;
	
	public GameEditor(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
		
		guiElements = new Array<GuiElement>();
		
		createMenu();
	}
	
	public Array<GuiElement> getGuiElements() {
		return guiElements;
	}

	@Override
	public boolean isTouched(Rectangle obj) {
		boolean flag = false;
		for (GuiElement element : guiElements) {
			if (element instanceof Interactor<?>) {
					if (((Interactor) element).isTouched(obj)) {
						flag = true;
						break;
					}
			}
		}
		
		return flag;
	}

	@Override
	public void drawInteractor() {
		// TODO Auto-generated method stub
		
	}
	
	public void createMenu() {
		final float d = 1;
		final TextArea tx = new TextArea();
		final TextArea txInd= new TextArea();
		final TextArea txGroup = new TextArea();
		final TextArea txRaio = new TextArea();
		
		ImageButton start = new ImageButton(AssestsLoader.instance.startIcon);
		start.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				GameOptions.instance.resume();
			}
		});
		
		ImageButton stop = new ImageButton(AssestsLoader.instance.stopIcon);
		stop.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				GameOptions.instance.pause();
			}
		});
		
		ImageButton refresh = new ImageButton(AssestsLoader.instance.refreshIcon);
		refresh.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				gameWorld.createSwarm();
				SwarmConstants.reset();
				GameOptions.instance.pause();
				tx.setText("Aleatory " + SwarmConstants.c3);
				txGroup.setText("Group " + SwarmConstants.c1);
				txInd.setText("Ind " + SwarmConstants.c2);
				txRaio.setText("Raio " + SwarmConstants.raio);
			}
		});
		
		BaseContainer raio = new BaseContainer(0, 0);
		raio.setColor(241f/255, 196f/255, 15f/255, 1f);
		txRaio.setWidth(75);
		txRaio.setText("Raio " + SwarmConstants.raio);
		txRaio.setPadding(10, 14);
		ImageButton plus = new ImageButton(AssestsLoader.instance.plusIcon);
		plus.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				SwarmConstants.raio += d;
				txRaio.setText("Raio " + SwarmConstants.raio);
			}
		});
		
		ImageButton minus = new ImageButton(AssestsLoader.instance.minusIcon);
		minus.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				SwarmConstants.raio -= d;
				
				if (SwarmConstants.raio < 0) {
					SwarmConstants.raio = 0;
				}
				
				txRaio.setText("Raio " + SwarmConstants.raio);
			}
		});
		
		raio.addGuiElement(txRaio);
		raio.addGuiElement(plus);
		raio.addGuiElement(minus);
		
		BaseContainer menu = new BaseContainer(30, 30);
		menu.setPadding(10, 10);
		menu.setColor(0, 0, 0,0.3f);
		
		menu.addGuiElement(start);
		menu.addGuiElement(stop);
		menu.addGuiElement(refresh);
		menu.addGuiElement(raio);

		tx.setWidth(75);
		tx.setText("Aleatory " + SwarmConstants.c3);
		tx.setPadding(10, 14);
		
		BaseContainer aleatory = new BaseContainer(0,0);
		aleatory.setColor(231f/255, 76f/255, 16f/255, 1f);
		ImageButton inc = new ImageButton(AssestsLoader.instance.plusIcon);
		inc.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				SwarmConstants.c3 += d;
				
				if (SwarmConstants.c3 > 3) {
					SwarmConstants.c3 = 3;
				}
				
				tx.setText("Aleatory: " + SwarmConstants.c3);
				
				if (gameWorld.getSwarm() != null) {
					gameWorld.getSwarm().setAleatory(SwarmConstants.c3);
				}
			}
		});
		
		ImageButton dec = new ImageButton(AssestsLoader.instance.minusIcon);
		dec.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				SwarmConstants.c3 -= d;
				
				if (SwarmConstants.c3 < 0) {
					SwarmConstants.c3 = 0;
				}
				
				tx.setText("Aleatory: " + SwarmConstants.c3);
			}
		});
		
		aleatory.addGuiElement(tx);
		aleatory.addGuiElement(inc);
		aleatory.addGuiElement(dec);
		
		menu.addGuiElement(aleatory);
		
		txGroup.setWidth(75);
		txGroup.setText("Group " + SwarmConstants.c1);
		txGroup.setPadding(10, 14);
		
		BaseContainer group = new BaseContainer(0,0);
		group.setColor(46f/255, 204f/255, 133f/255, 1f);
		ImageButton incgroup = new ImageButton(AssestsLoader.instance.plusIcon);
		incgroup.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				SwarmConstants.c1 += d;
				
				if (SwarmConstants.c1 > 3) {
					SwarmConstants.c1 = 3;
				}
				
				txGroup.setText("Group: " + SwarmConstants.c1);
			}
		});
		
		ImageButton decgroup = new ImageButton(AssestsLoader.instance.minusIcon);
		decgroup.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				SwarmConstants.c1 -= d;
				
				if (SwarmConstants.c1 < 0) {
					SwarmConstants.c1 = 0;
				}
				
				txGroup.setText("Group: " + SwarmConstants.c1);
			}
		});
		
		group.addGuiElement(txGroup);
		group.addGuiElement(incgroup);
		group.addGuiElement(decgroup);
		
		menu.addGuiElement(group);
		
		txInd.setWidth(75);
		txInd.setText("Ind " + SwarmConstants.c2);
		txInd.setPadding(10, 14);
		
		BaseContainer ind = new BaseContainer(0,0);
		ind.setColor(41f/255, 128f/255, 185f/255, 1f);
		ImageButton incind = new ImageButton(AssestsLoader.instance.plusIcon);
		incind.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				SwarmConstants.c2 += d;
				
				if (SwarmConstants.c2 > 3) {
					SwarmConstants.c2 = 3;
				}
				
				txInd.setText("Ind: " + SwarmConstants.c2);
			}
		});
		
		ImageButton decind = new ImageButton(AssestsLoader.instance.minusIcon);
		decind.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				SwarmConstants.c2 -= d;
				
				if (SwarmConstants.c2 < 0) {
					SwarmConstants.c2 = 0;
				}
				
				txInd.setText("Ind: " + SwarmConstants.c2);
			}
		});
		
		ind.addGuiElement(txInd);
		ind.addGuiElement(incind);
		ind.addGuiElement(decind);
		
		menu.addGuiElement(ind);
		
		guiElements.add(menu);
		
		menu.setPosition(30, 30);
	}
}
