package geradores;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeraSynonym {
	public static void gerar(String owner, String synonym)throws IOException{
		File f = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try{
			f = new File("ts_sistema."+synonym+"_ddl.sql");
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			bw.write("set echo on\n");
			bw.write("set define off\n");
			bw.write(" \n");
			bw.write("create or replace synonym ts_sistema."+synonym+" for "+owner+"."+synonym+";");
		
		}finally{
			bw.close();
			fw.close();			
		}
		
	}

}
