package com.example.qcqc;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.Toast;
import com.malinskiy.ccontrols.*;

/**
 * Demo activity
 */
public class MainActivity extends Activity {
	private static float FLOAT_PI_DIVIDED_BY_TWO = (float) Math.PI / 2;
	private final static float sweep = FLOAT_PI_DIVIDED_BY_TWO / 2;
	private PieRenderer pieRenderer;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Important!!
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.main);

		pieRenderer = new PieRenderer(getApplicationContext());
		PieController pieController = new PieController(this, pieRenderer);

		RenderOverlay renderOverlay = (RenderOverlay) findViewById(R.id.render_overlay); // insert
																							// your
																							// id

		PieItem item0 = pieController
				.makeItem(android.R.drawable.arrow_up_float);
		item0.setFixedSlice(FLOAT_PI_DIVIDED_BY_TWO, sweep);
		item0.setOnClickListener(new PieItem.OnClickListener() {
			@Override
			public void onClick(PieItem item) {
				Toast.makeText(getApplicationContext(), "some cmd",
						Toast.LENGTH_SHORT).show();
			}
		});

		PieItem item1 = pieController
				.makeItem(android.R.drawable.arrow_up_float);
		item1.setFixedSlice(FLOAT_PI_DIVIDED_BY_TWO + sweep, sweep);
		item1.setOnClickListener(new PieItem.OnClickListener() {
			@Override
			public void onClick(PieItem item) {
				Toast.makeText(getApplicationContext(), "some cmd 2",
						Toast.LENGTH_SHORT).show();
			}
		});

		PieItem item7 = pieController
				.makeItem(android.R.drawable.arrow_up_float);
		item7.setFixedSlice(FLOAT_PI_DIVIDED_BY_TWO - sweep, sweep);
		item7.setOnClickListener(new PieItem.OnClickListener() {
			@Override
			public void onClick(PieItem item) {
				Toast.makeText(getApplicationContext(), "some cmd 7",
						Toast.LENGTH_SHORT).show();
			}
		});

		pieRenderer.addItem(item0);
		pieRenderer.addItem(item1);
		pieRenderer.addItem(item7);

		PieItem item0_0 = pieController
				.makeItem(android.R.drawable.ic_menu_add);
		item0_0.setFixedSlice(FLOAT_PI_DIVIDED_BY_TWO, sweep);
		item0_0.setOnClickListener(new PieItem.OnClickListener() {
			@Override
			public void onClick(PieItem item) {
				Toast.makeText(getApplicationContext(), "some cmd",
						Toast.LENGTH_SHORT).show();
			}
		});

		PieItem item0_6 = pieController
				.makeItem(android.R.drawable.ic_menu_add);
		item0_6.setFixedSlice(FLOAT_PI_DIVIDED_BY_TWO + sweep, sweep);
		item0_6.setOnClickListener(new PieItem.OnClickListener() {
			@Override
			public void onClick(PieItem item) {
				Toast.makeText(getApplicationContext(), "some cmd 2",
						Toast.LENGTH_SHORT).show();
			}
		});

		PieItem item0_7 = pieController
				.makeItem(android.R.drawable.ic_menu_add);
		item0_7.setFixedSlice(FLOAT_PI_DIVIDED_BY_TWO - sweep, sweep);
		item0_7.setOnClickListener(new PieItem.OnClickListener() {
			@Override
			public void onClick(PieItem item) {
				Toast.makeText(getApplicationContext(), "some cmd 7",
						Toast.LENGTH_SHORT).show();
			}
		});

		item0.addItem(item0_0);
		item0.addItem(item0_6);
		item0.addItem(item0_7);

		renderOverlay.addRenderer(pieRenderer);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		pieRenderer.onTouchEvent(event);
		return super.onTouchEvent(event);
	}
}