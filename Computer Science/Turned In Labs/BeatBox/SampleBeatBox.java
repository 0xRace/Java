public class SampleBeatBox
{
	public static void main(String[] args)
	{

		BeatBox box;
        box = new BeatBox();

		// check Instruments.java to see the instruments you can use

	    // standard 16 tick track
		box.newTrack(16);

		// straight base line
		box.addBeat(0, 35);
		box.addBeat(4, 35);
		box.addBeat(8, 35);
		box.addBeat(12, 35);

		// add an open triangle
		box.addBeat(2, 81);

 		// clap on the off-beat...
 		box.addBeat(6, 39);
		// double clap on the off-beat...
		box.addBeat(10, 39);
		box.addBeat(11, 39);

		// finalize this track
		box.endTrack();

		// play the track!!!
		box.start();
	}
}
