import java.io.*;

public class SubToTxt {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("Primer.sub");
			BufferedReader br = new BufferedReader(fr);
			String linija = br.readLine();
			double ukupno = 0;
			while (linija != null) {
				linija.replaceAll("\n", "\\|");
				if (linija.startsWith("0") || linija.startsWith("1") || linija.startsWith("2") || linija.startsWith("3")
						|| linija.startsWith("4") || linija.startsWith("5") || linija.startsWith("6")
						|| linija.startsWith("7") || linija.startsWith("8") || linija.startsWith("9")
						|| linija.startsWith(" ")) {
					String[] podela = linija.split(" ");
					double pocetak = Double.parseDouble(podela[0]);
					double kraj = Double.parseDouble(podela[1]);
					ispis(pocetak, kraj, ukupno, linija);
					ukupno += pocetak + kraj;
				} else {
					System.out.print(linija);
					try {
						FileWriter fw = new FileWriter("SubToTxt.txt", true);
						fw.write(linija);
						fw.flush();
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				linija = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void ispis(double pocetak, double kraj, double ukupno, String linija) {
		String ispis = "";
		double prvi = (pocetak + ukupno) * 25;
		int prviInt = (int) prvi;
		ispis += "{" + prviInt + "}";
		double drugi = (ukupno + kraj + pocetak) * 25;
		int drugiInt = (int) drugi;
		ispis += "{" + drugiInt + "}";
		System.out.print("\n" + ispis);
		try {
			FileWriter fw = new FileWriter("SubToTxt.txt", true);
			fw.write("\n" + ispis);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
