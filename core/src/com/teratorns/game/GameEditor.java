package com.teratorns.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.gui.BaseContainer;
import com.teratorns.gui.GuiElement;
import com.teratorns.gui.ImageButton;
import com.teratorns.gui.TextArea;
import com.teratorns.interaction.ActionListener;
import com.teratorns.interaction.Interactor;
import com.teratorns.objects.SwarmConstants;

public class GameEditor implements Interactor<Rectangle> {
	
	private Array<GuiElement> guiElements;
	private GameWorld gameWorld;
	
	public GameEditor(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
		
		guiElements = new Array<GuiElement>();
		
		createMenu();
	}
	
	public Array<GuiElement> getGuiElements() {
		return guiElements;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isTouched(Rectangle obj) {
		boolean flag = false;
		for (GuiElement element : guiElements) {
			if (element instanceof Interactor<?>) {
					if (((Interactor<Rectangle> ) element).isTouched(obj)) {
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
		final int d = 1;
		final TextArea tx = new TextArea();
		final TextArea txInd= new TextArea();
		final TextArea txGroup = new TextArea();
		final TextArea txRaio = new TextArea();
		
		ImageButton start = new ImageButton(AssetsLoader.instance.startIcon);
		start.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				GameOptions.instance.resume();
			}
		});
		
		ImageButton stop = new ImageButton(AssetsLoader.instance.stopIcon);
		stop.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				GameOptions.instance.pause();
			}
		});
		
		ImageButton refresh = new ImageButton(AssetsLoader.instance.refreshIcon);
		refresh.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				gameWorld.createSwarm();
				SwarmConstants.reset();
				GameOptions.instance.pause();
				tx.setText("Aleatory " + SwarmConstants.c3);
				txGroup.setText("Group " + SwarmConstants.c2);
				txInd.setText("Ind " + SwarmConstants.c1);
				txRaio.setText("Raio " + SwarmConstants.raio);
			}
		});
		
		BaseContainer raio = new BaseContainer(0, 0);
		raio.setColor(241f/255, 196f/255, 15f/255, 1f);
		txRaio.setWidth(75);
		txRaio.setText("Raio " + SwarmConstants.raio);
		txRaio.setPadding(10, 14);
		ImageButton plus = new ImageButton(AssetsLoader.instance.plusIcon);
		plus.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				SwarmConstants.raio += d;
				txRaio.setText("Raio " + SwarmConstants.raio);
			}
		});
		
		ImageButton minus = new ImageButton(AssetsLoader.instance.minusIcon);
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
		
		BaseContainer menu = new BaseContainer(10, 10);
		menu.setTag("Menu");
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
		ImageButton inc = new ImageButton(AssetsLoader.instance.plusIcon);
		inc.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				SwarmConstants.c3 += d;
				
				if (SwarmConstants.c3 > 3) {
					SwarmConstants.c3 = 3;
				}
				
				tx.setText("Aleatory: " + SwarmConstants.c3);
			}
		});
		
		ImageButton dec = new ImageButton(AssetsLoader.instance.minusIcon);
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
		txGroup.setText("Group " + SwarmConstants.c2);
		txGroup.setPadding(10, 14);
		
		BaseContainer group = new BaseContainer(0,0);
		group.setColor(46f/255, 204f/255, 133f/255, 1f);
		ImageButton incgroup = new ImageButton(AssetsLoader.instance.plusIcon);
		incgroup.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				SwarmConstants.c2 += d;
				
				if (SwarmConstants.c2 > 3) {
					SwarmConstants.c2 = 3;
				}
				
				txGroup.setText("Group: " + SwarmConstants.c2);
			}
		});
		
		ImageButton decgroup = new ImageButton(AssetsLoader.instance.minusIcon);
		decgroup.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				SwarmConstants.c2 -= d;
				
				if (SwarmConstants.c2 < 0) {
					SwarmConstants.c2 = 0;
				}
				
				txGroup.setText("Group: " + SwarmConstants.c2);
			}
		});
		
		group.addGuiElement(txGroup);
		group.addGuiElement(incgroup);
		group.addGuiElement(decgroup);
		
		menu.addGuiElement(group);
		
		txInd.setWidth(75);
		txInd.setText("Ind " + SwarmConstants.c1);
		txInd.setPadding(10, 14);
		
		BaseContainer ind = new BaseContainer(0,0);
		ind.setColor(41f/255, 128f/255, 185f/255, 1f);
		ImageButton incind = new ImageButton(AssetsLoader.instance.plusIcon);
		incind.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				SwarmConstants.c1 += d;
				
				if (SwarmConstants.c1 > 3) {
					SwarmConstants.c1 = 3;
				}
				
				txInd.setText("Ind: " + SwarmConstants.c1);
			}
		});
		
		ImageButton decind = new ImageButton(AssetsLoader.instance.minusIcon);
		decind.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				SwarmConstants.c1 -= d;
				
				if (SwarmConstants.c1 < 0) {
					SwarmConstants.c1 = 0;
				}
				
				txInd.setText("Ind: " + SwarmConstants.c1);
			}
		});
		
		ind.addGuiElement(txInd);
		ind.addGuiElement(incind);
		ind.addGuiElement(decind);
		
		menu.addGuiElement(ind);
		
		guiElements.add(menu);
		
		//menu.setPosition(30, 30);
		
		TextArea teratorns = new TextArea();
		teratorns.setText("TERATORNS");
		teratorns.setScale(0.5f);
		teratorns.setTextColor(155.0f/255, 89.0f/255, 182.0f/255, 0.7f);
		TextArea framework = new TextArea();
		framework.setPosition(30, 20);
		framework.setText("f r a m e w o r k");
		framework.setTextColor(0, 0, 0, 0.3f);
		BaseContainer teratornsLogo = new BaseContainer(10, 80);
		teratornsLogo.setColor(0,0,0,0);
		teratornsLogo.addGuiElement(teratorns);
		teratornsLogo.addGuiElement(framework);
		
		guiElements.add(teratornsLogo);
	}
}
