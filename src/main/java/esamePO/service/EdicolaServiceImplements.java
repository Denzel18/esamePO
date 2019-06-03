package esamePO.service;
import org.springframework.stereotype.Service;
import esamePO.model.Edicola;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service("edicolaService")
public class EdicolaServiceImplements  implements EdicolaService {
		
		private static final AtomicLong counter = new AtomicLong();
		
		private static List<Edicola> Edicolas;
		
		static{
			Edicolas= populateDummyEdicolas();
		}

		public List<Edicola> findAllEdicolas() {
			return Edicolas;
		}
		
		public Edicola findById(String id) {
			for(Edicola Edicola : Edicolas){
				if(Edicola.getCodice() == id){
					return Edicola;
				}
			}
			return null;
		}
		
		
		public void saveEdicola(Edicola Edicola) {
			Edicola.setCodice("ID : "+counter.incrementAndGet());
			Edicolas.add(Edicola);
		}

		public void updateEdicola(Edicola Edicola) {
			int index = Edicolas.indexOf(Edicola);
			Edicolas.set(index, Edicola);
		}

		public void deleteEdicolaById(String id) {
			
			for (Iterator<Edicola> iterator = Edicolas.iterator(); iterator.hasNext(); ) {
			    Edicola Edicola = iterator.next();
			    if (Edicola.getCodice() == id) {
			        iterator.remove();
			    }
			}
		}

		
		public void deleteAllEdicolas(){
			Edicolas.clear();
		}

		private static List<Edicola> populateDummyEdicolas(){
			List<Edicola> Edicolas = new ArrayList<Edicola>();
			Double[]  location  = new Double [] {0.9999,1.122};
			Edicolas.add(new Edicola ("AA","BB","CC","DD",54,123,"AA","XX",true,4, 0.672811, 0.123123,location));
			return Edicolas;
		}

		public Edicola getEdicolaByCodice(long codice) {
			// TODO Auto-generated method stub
			return null;
		}

		public double avgData(List<Edicola> edicole, String data) {
			// TODO Auto-generated method stub
			return 0;
		}

		public double minData(List<Edicola> edicole, String data) {
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
			// TODO Auto-generated method stub
			return null;
		}

	}

