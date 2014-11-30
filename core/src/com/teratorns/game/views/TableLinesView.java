package com.teratorns.game.views;

import com.teratorns.game.TableLine;
import com.teratorns.view.Layer;
import com.teratorns.view.View;

public class TableLinesView extends View {

	private TableLine tableLine;
	
	public TableLinesView(TableLine tableLine) {
		this.tableLine = tableLine;
		this.addLayer(new LinesLayer());
	}
	
	private class LinesLayer extends Layer {

		@Override
		public void draw() {
			tableLine.draw();
		}
	}
}
