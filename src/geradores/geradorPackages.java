package geradores;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;


public class geradorPackages {
	
	private static String owner;
	private static String nome;
	private static String sufixSPC = "_pkg.ddl.sql";
	private static String sufixBDY = "_pkg.bdy.sql";
	
	private static void packageSPC() throws IOException{
		File f = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			
			String nome_arquivo = owner+"."+nome+sufixSPC;
			String nome_completo = owner+"."+nome;
			
			f = new File(nome_arquivo);
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			
			bw.write("set echo on                                                                                  "+"\n");
			bw.write("set define off                                                                               "+"\n");
			bw.write("                                                                                             "+"\n");
			bw.write("create or replace                                                                            "+"\n");
			bw.write("package "+nome_completo+"                                                                    "+"\n");
			bw.write("is                                                                                           "+"\n");
			bw.write("pragma serially_reusable;                                                                    "+"\n");
			bw.write("	--                                                                                         "+"\n");
			bw.write("	--                                                                                         "+"\n");
			bw.write("	function  p_versao return varchar2;                                                        "+"\n");
			bw.write("	--                                                                                         "+"\n");
			bw.write("end;                                                                                         "+"\n");
			bw.write("/                                                                                            "+"\n");
			bw.write("grant execute on "+nome_completo+" to web_app,saude_app,ts_sistema                           "+"\n");
			bw.write("/                                                                                            "+"\n");
			
		} finally{
			bw.close();
			fw.close();
			
		}
	}
	private static void packageBDY() throws IOException{
		File f = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			
			String nome_arquivo = owner+"."+nome+sufixBDY;
			String nome_completo = owner+"."+nome;
			
			f = new File(nome_arquivo);
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			
			bw.write("set echo on                                                                                  "+"\n");
			bw.write("set define off                                                                               "+"\n");
			bw.write("                                                                                             "+"\n");
			bw.write("create or replace                                                                            "+"\n");
			bw.write("package body "+nome_completo+"                                                               "+"\n");
			bw.write("is                                                                                           "+"\n");
			bw.write("pragma serially_reusable;                                                                    "+"\n");
			bw.write("	--                                                                                         "+"\n");
			bw.write("	--                                                                                         "+"\n");
			
			bw.write("	function p_versao return varchar2                                                          "+"\n");
			bw.write("	is                                                                                         "+"\n");
			bw.write("	begin                                                                                      "+"\n");
			bw.write("	 return 'CVS: SPEC 1.1 - BDY 1.1';                                                         "+"\n");
			bw.write("	end;                                                                                       "+"\n");
			
			bw.write("	--                                                                                         "+"\n");
			bw.write("end;                                                                                         "+"\n");
			bw.write("/                                                                                            "+"\n");
			bw.write("grant execute on "+nome_completo+" to web_app,saude_app,ts_sistema                           "+"\n");
			bw.write("/                                                                                            "+"\n");
			
		} finally{
			bw.close();
			fw.close();
			
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		owner = JOptionPane.showInputDialog("Insira o Owner da package: \n Ex:ts_owner");
		nome = JOptionPane.showInputDialog("Insira o nome da package: \n Ex:odo_pag_fhc_parametros");;
		packageSPC();
		packageBDY();
		JOptionPane.showMessageDialog(null, "Rotina "+owner+"."+nome+" criada!");
	}
}
