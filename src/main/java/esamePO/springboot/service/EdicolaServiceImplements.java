package esamePO.springboot.service;
import org.springframework.stereotype.Service;
import esamePO.springboot.model.Edicola;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service("edicolaService")
public class EdicolaServiceImplements  implements EdicolaService {
		
		private static final AtomicLong counter = new AtomicLong();
		
		private static List<Edicola> edicole;
		
		static{
			edicole= populateDummyEdicolas();
		}

		public List<Edicola> findAllEdicolas() {
			return edicole;
		}
		
		public Edicola getEdicolaById(int id) {
			for(Edicola Edicola : edicole){
				System.out.println("CODICE : "+Edicola.getCodice());
				if(Edicola.getId() == id){
					return Edicola;
				}
			}
			return null;
		}
		
		
		public void saveEdicola(Edicola Edicola) {
			Edicola.setCodice("ID : "+counter.incrementAndGet());
			edicole.add(Edicola);
		}

		public void updateEdicola(Edicola Edicola) {
			int index = edicole.indexOf(Edicola);
			edicole.set(index, Edicola);
		}

		public void deleteAllEdicolas(){
			edicole.clear();
		}

		private static List<Edicola> populateDummyEdicolas(){
			List<Edicola> edicole = new ArrayList<Edicola>();
			int n = 10; 
			edicole.add(new Edicola(1));
			for(int i=2;i<n ;i++) {
				Edicola x = new Edicola (i);
				System.out.println(x.toString());
				edicole.add(new Edicola(i));
			}
			return edicole;
		}

		public Edicola getEdicolaByCodice(String codice) {
			for(Edicola Edicola : edicole){
				if(Edicola.getCodice() == codice){
					return Edicola;
				}
			}
			return null;
		}

		public double avgData(List<Edicola> edicole, String data) {
			double somma = this.sumData(edicole, data);
			double conteggio = this.countData(edicole, data);
			double media = somma/conteggio; 
			return media;
		}

		public double minData(List<Edicola> edicole, String data) {
			for(Edicola Edicola : edicole){

				
			}
			// TODO Auto-generated method stub
			return 0;
		}

		public double maxData(List<Edicola> edicole, String data) {
			// TODO Auto-generated method stub
			return 0;
		}

		public double devStdData(List<Edicola> edicole, String data) {
			// TODO Auto-generated method stub
			return 0;
		}

		public double sumData(List<Edicola> edicole, String data) {
			// TODO Auto-generated method stub
			return 0;
		}

		public double countData(List<Edicola> edicole, String data) {
			// TODO Auto-generated method stub
			return 0;
		}

		public int countDataString(List<Edicola> edicole, String data) {
			// TODO Auto-generated method stub
			return 0;
		}

		public Edicola getEdicolaById(String codice) {
			// TODO Auto-generated method stub
			return null;
		}

		public List<Edicola> getAllEdicola() {
			return EdicolaServiceImplements.edicole;
		}

	}

