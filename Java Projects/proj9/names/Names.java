package names;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Names {
	HashMap<Integer, HashMap<Boolean, HashMap<Integer, String>>> struct = new HashMap<Integer, HashMap<Boolean, HashMap<Integer, String>>>();
	ArrayList<String> copy = new ArrayList<String>();
	private static String sync = "";

	public int numNamePairs() {

		int x = 0;
		for (Integer i : struct.keySet()) {
			x = x + struct.get(i).get(true).size();
		}
		return x;
	}

	public void getNames(String[] urls) {
		if (urls == null) {
			throw new IllegalArgumentException();
		}
		for (String s : urls) {
			copy.add(s);

		}
		HashSet<Thread> endThis = new HashSet<Thread>();
		for (String s : urls) {
			myThread temp = new myThread();
			endThis.add(temp);
			temp.start();
		}
		for (Thread endPlease : endThis) {
			try {
				endPlease.join();
			} catch (InterruptedException e) {

			}
		}

	}

	public String getGirlName(int year, int rank) {
		// throw new UnsupportedOperationException("You must write this
		// method.");
		if (struct.containsKey(year)) {
			ArrayList<Integer> ar = new ArrayList<Integer>();
			for (Integer i : struct.get(year).get(true).keySet()) {
				ar.add(i);
			}
			Collections.sort(ar);
			// System.out.println(ar.get(0));
			// System.out.println(ar.get(ar.size()-1));
			return struct.get(year).get(true).get(ar.get(ar.size() - rank));

		}
		return null;
	}

	public String getBoyName(int year, int rank) {
		if (struct.containsKey(year)) {
			ArrayList<Integer> ar = new ArrayList<Integer>();
			for (Integer i : struct.get(year).get(false).keySet()) {
				ar.add(i);
			}
			Collections.sort(ar);
			System.out.println(ar.get(0));
			System.out.println(ar.get(ar.size() - 1));
			return struct.get(year).get(false).get(ar.get(ar.size() - rank));

		}
		return null;
	}

	public int getGirlRank(int year, String name) {
		if (struct.containsKey(year) ) {
			ArrayList<Integer> ar = new ArrayList<Integer>();
			for (Integer i : struct.get(year).get(true).keySet()) {
				ar.add(i);
			}
			Collections.sort(ar);
			for (int i = 0; i < ar.size(); i++) {
				if (struct.get(year).get(true).get(ar.get(i)).equals(name)) {
					return ar.size() - i;
				}
			}

		}
		return -1;
	}

	public int getBoyRank(int year, String name) {
		if (struct.containsKey(year) ) {
			ArrayList<Integer> ar = new ArrayList<Integer>();
			for (Integer i : struct.get(year).get(false).keySet()) {
				ar.add(i);
			}
			Collections.sort(ar);
			for (int i = 0; i < ar.size(); i++) {
				if (struct.get(year).get(false).get(ar.get(i)).equals(name)) {
					return ar.size() - i;
				}
			}

		}
		return -1;

	}

	class myThread extends Thread {
		{
			try {
				URL url = new URL(copy.remove(0));
				URLConnection conn = url.openConnection();
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				for (int i = 0; i < 11; i++) {
					br.readLine();
				}
				String in;
				synchronized (sync) {
					while (!(in = br.readLine()).equals("</body>")) {
						in = in.substring(0, in.length() - 4);
						String[] info = in.split(" ");
						int year = Integer.parseInt(info[0]);
						int mRank = Integer.parseInt(info[2]);
						int fRank = Integer.parseInt(info[4]);
						if (!struct.containsKey(year)) {

							struct.put(year, new HashMap<Boolean, HashMap<Integer, String>>());
							struct.get(year).put(true, new HashMap<Integer, String>());
							struct.get(year).put(false, new HashMap<Integer, String>());

						}
						struct.get(year).get(false).put(mRank, info[1]);
						struct.get(year).get(true).put(fRank, info[3]);

					}
				}
				br.close();

			} catch (MalformedURLException e) {

			} catch (IOException e1) {

			}

		}
	}
}
