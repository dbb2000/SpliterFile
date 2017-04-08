package br.com.splitter.sap.splitter;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe reponsável por fazer a quebra das linhas de registro do arquivo .csv
 * @author Rodrigo Zaratin
 */
    public class SAPSplitter
{   
        //static int lines;
    
  /*  public static void main(String[] args)
    {
        System.out.println("Iniciando aplicacao");
            
        if(args.length==2)
        {
            if(args[0].toUpperCase().equals("T"))
            {
                System.out.println("Iniciando analise do arquivo de Terceiros");
                SplitFile("TERC",args[1]);
            }
            else if (args[0].toUpperCase().equals("F"))
            {
                System.out.println("Iniciando analise do arquivo de Funcionarios");
                SplitFile("FUNC",args[1]);
            }
            else
            {
                System.out.println("Erro: Parametros de tipo de arquivo invalido!");
            }
        }
        else
        {
            System.out.println("Erro: Quantidade de parametros invalida!");
        }
        
        System.out.println("Finalizando aplicacao");
    }
   */
    
        /**
         * Método que faz a quebra de linhas de registro de arquivo .csv
         * 
         */
    public static void splitFile(String type, String fileFromSAP, int lines)
    {
        
        
         
        try
        {
            String splits1[] = fileFromSAP.split("_");
            String dataFile = splits1[splits1.length-1].substring(0,splits1[splits1.length-1].indexOf("."));
            String finalFileName = "SAP_"+type+"_"+dataFile+"_";
            

            System.out.println("Abrindo arquivo: "+fileFromSAP);
            // TODO: verificar por quê esta variável não foi usada.
            BufferedReader in = new BufferedReader(new FileReader(fileFromSAP));
            
            String line;
            int fileCount = 1;
            int lineCount = 0;
            boolean firsLine = true;
            String sFirstLine = "";
            
            //String t = Painel.num_lines.getText();
            //String convert = String.valueOf(t);
            //int lines = Integer.parseInt(convert);
                                          
            BufferedWriter out = new BufferedWriter(new FileWriter(finalFileName+fileCount+".csv"));
            
            while ((line = in.readLine()) != null)
            {
                if(firsLine)
                {
                    sFirstLine = line;
                }
                                
                if(lineCount==lines)
                {
                    out.flush();
                    out.close();
                    lineCount=0;
                }
                
                if(lineCount==0)
                {
                    out = new BufferedWriter(new FileWriter(finalFileName+fileCount+".csv"));
                    if(firsLine)
                    {
                        out.write(line);
                        firsLine = false;
                    }
                    else
                    {
                        out.write(sFirstLine);
                        out.newLine();
                        out.write(line);
                    }
                    
                    out.newLine();
                    lineCount++;
                    fileCount++;
                }
                else
                {
                    out.write(line);
                    out.newLine();
                    lineCount++;
                }
            }
            
            try
            {
                out.flush();
                out.close();
            }catch(Exception e1)
            {
            }
        } catch(FileNotFoundException ex1)
        {
            System.out.println("Erro dividindo arquivo de "+type+": ");
            ex1.printStackTrace();
        }
        catch(IOException ex2)
        {
            System.out.println("Erro dividindo arquivo de "+type+": ");
            ex2.printStackTrace();
        }
    }
}
