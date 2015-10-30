package cs301.cannon;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * CannonMainActivity
 * 
 * This is the activity for the cannon animation. It creates a AnimationCanvas
 * containing a particular Animator object
 * 
 * @author Andrew Nuxoll
 * @version September 2012
 * 
 */
public class CannonMainActivity extends Activity {


	private SeekBar angleSeek;
	private TextView angleDisplay;
	/**
	 * creates an AnimationCanvas containing a TestAnimator.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cannon_main);

		angleSeek = (SeekBar)findViewById(R.id.angleSeek);
		angleDisplay = (TextView)findViewById(R.id.angleText);

		angleSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				angleDisplay.setText(String.valueOf(progress));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});

		// Create an animation canvas and place it in the main layout
		Animator testAnim = new TestAnimator();
		AnimationCanvas myCanvas = new AnimationCanvas(this, testAnim);
		LinearLayout mainLayout = (LinearLayout) this
				.findViewById(R.id.topLevelLayout);
		mainLayout.addView(myCanvas);

	}

	/**
	 * This is the default behavior (empty menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.cannon_main, menu);
		return true;
	}
}
