package com.teratorns.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.teratorns.assets.AssetsLoader;
import com.teratorns.gui.BaseButton;
import com.teratorns.gui.BaseContainer;
import com.teratorns.gui.Container.ContainerAlignment;
import com.teratorns.gui.GuiElement;
import com.teratorns.gui.ImageButton;
import com.teratorns.gui.TextButton;
import com.teratorns.interaction.ActionListener;
import com.teratorns.interaction.Interactor;

public class GameGui implements Interactor<Rectangle> {
	
	private Array<GuiElement> guiElements;
	
	public GameGui() {
		
		guiElements = new Array<GuiElement>();
		
		createGui();
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
	
	private void createGui() {
		final BaseContainer container1 = new BaseContainer(0,0);
		container1.setPadding(20, 20);
		container1.setColor(0,0,0,0);
		BaseContainer container2 = new BaseContainer(0,0);
		container2.setPadding(20, 20);
		container2.setColor(0,0,0,0);
		BaseContainer container3 = new BaseContainer(0,0);
		container3.setPadding(20, 20);
		container3.setAlignment(ContainerAlignment.VERTICAL);
		container3.setColor(0,0,0,0);
		BaseContainer container4 = new BaseContainer(981,0);
		container4.setPadding(74, 40);
		container4.setAlignment(ContainerAlignment.VERTICAL);
		container4.setColor(0,0,0,0);
		
		final ImageButton button1 = new ImageButton(AssetsLoader.instance.lC);
		button1.setDimensions(200, 200);
		button1.setPosition(0, 20);
		button1.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				stopMusic();
				button1.setImage(AssetsLoader.instance.carol1);
				AssetsLoader.instance.roberto.play();
			}
		});
		
		final ImageButton button2 = new ImageButton(AssetsLoader.instance.lA);
		button2.setDimensions(110, 300);
		button2.setPosition(10, 20);
		button2.setActionListener(new ActionListener() {
					
			@Override
			public void doAction() {
				button2.setImage(AssetsLoader.instance.carol3);
			}
		});
		
		final ImageButton button3 = new ImageButton(AssetsLoader.instance.lR);
		button3.setDimensions(100, 100);
		button3.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				stopMusic();
				button3.setImage(AssetsLoader.instance.carol2);
				AssetsLoader.instance.elis.play();
			}
		});
		
		final ImageButton button4 = new ImageButton(AssetsLoader.instance.lO);
		button4.setDimensions(300, 300);
		button4.setPosition(60, 20);
		button4.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				button4.setImage(AssetsLoader.instance.carol4);
			}
		});
		
		final ImageButton button5 = new ImageButton(AssetsLoader.instance.lL);
		button5.setDimensions(168, 300);
		button5.setPosition(0, 0);
		button5.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				button5.setImage(AssetsLoader.instance.carol8);
			}
		});
		
		final ImageButton button6 = new ImageButton(AssetsLoader.instance.lI);
		button6.setDimensions(100, 100);
		button6.setPosition(50, 50);
		button6.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				button6.setImage(AssetsLoader.instance.carol6);
			}
		});
		
		final ImageButton button7 = new ImageButton(AssetsLoader.instance.lN);
		button7.setDimensions(200, 200);
		button7.setPosition(20, 0);
		button7.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				button7.setImage(AssetsLoader.instance.carol7);
			}
		});
		
		final ImageButton button8 = new ImageButton(AssetsLoader.instance.lA);
		button8.setDimensions(150, 312);
		button8.setPosition(60, 10);
		button8.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				button8.setImage(AssetsLoader.instance.carol5);
			}
		});
		
		TextButton button9 = new TextButton(new BaseButton(20, 1, 920, 68));
		button9.setText("ITABAIANA");
		button9.setColor(Color.CYAN);
		
		final ImageButton button10 = new ImageButton(AssetsLoader.instance.song);
		button10.setDimensions(150, 150);
		button10.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				stopMusic();
				button10.setImage(AssetsLoader.instance.elisCd);
				AssetsLoader.instance.elis.play();
			}
		});
		
		final ImageButton button11 = new ImageButton(AssetsLoader.instance.song);
		button11.setDimensions(150, 150);
		button11.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				stopMusic();
				button11.setImage(AssetsLoader.instance.robertoCd);
				AssetsLoader.instance.roberto.play();
			}
		});
		
		final ImageButton button12 = new ImageButton(AssetsLoader.instance.song);
		button12.setDimensions(150, 150);
		button12.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				stopMusic();
				button12.setImage(AssetsLoader.instance.chicoCd);
				AssetsLoader.instance.chico.play();
			}
		});
		
		final ImageButton button13 = new ImageButton(AssetsLoader.instance.song);
		button13.setDimensions(150, 150);
		button13.setActionListener(new ActionListener() {
			
			@Override
			public void doAction() {
				stopMusic();
				container1.setVisible(true);
				button13.setImage(AssetsLoader.instance.miltonCd);
				AssetsLoader.instance.milton.play();
			}
		});
		
		container1.addGuiElement(button1);
		container1.addGuiElement(button2);
		container1.addGuiElement(button3);
		container1.addGuiElement(button4);
		container1.setVisible(false);
		container2.addGuiElement(button5);
		container2.addGuiElement(button6);
		container2.addGuiElement(button7);
		container2.addGuiElement(button8);
		
		container3.addGuiElement(container1);
		container3.addGuiElement(container2);
		//container3.addGuiElement(button9);
		
		container4.addGuiElement(button10);
		container4.addGuiElement(button11);
		container4.addGuiElement(button12);
		container4.addGuiElement(button13);
		
		guiElements.add(container3);
		guiElements.add(container4);
	}
	
	private void stopMusic() {
		AssetsLoader.instance.milton.stop();
		AssetsLoader.instance.elis.stop();
		AssetsLoader.instance.roberto.stop();
		AssetsLoader.instance.chico.stop();
	}
}
