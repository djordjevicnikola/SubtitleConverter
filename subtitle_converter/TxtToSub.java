package domaci17092019;

import java.io.*;

public class TxtToSub {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("Primer.txt");
			BufferedReader br = new BufferedReader(fr);
			String linija = br.readLine();
			double ukupno = 0;
			while (linija != null) {
				String[] podela = linija.split("}");
				double pocetak = Integer.parseInt(podela[0].substring(1));
				double kraj = Integer.parseInt(podela[1].substring(1));
				ispis(pocetak, kraj, ukupno, linija);
				ukupno = kraj;
				linija = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void ispis(double pocetak, double kraj, double ukupno, String linija) {
		String[] podela = linija.split("}");
		String ispis;
		if (podela[2].charAt(0) == '{') {
			ispis = (pocetak - ukupno) / 25 + " " + (kraj - pocetak) / 25 + "\n" + podela[3] + "\n";
			ispis = ispis.replaceAll("\\|", "\n");
		} else {
			ispis = (pocetak - ukupno) / 25 + " " + (kraj - pocetak) / 25 + "\n" + podela[2] + "\n";
			ispis = ispis.replaceAll("\\|", "\n");
		}
		System.out.println(ispis);
		try {
			FileWriter fw = new FileWriter("TxtToSub.sub", true);
			fw.write(ispis + "\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
