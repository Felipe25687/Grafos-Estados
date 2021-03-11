import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.xy.IntervalXYDataset;

import javax.swing.JFrame;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;


public class Histograma extends JFrame{



    public static void main(String[] args) throws IOException {


        double[] grausDosEstados = {4, 2, 3, 5, 3, 2, 8, 3, 3, 5, 4, 4, 3, 3, 2, 1, 5, 5, 6, 6, 6, 4, 2, 1, 1, 2};

       double[] grausX = {1, 2, 3, 4, 5, 6, 8};
        //ArrayList<String[]> grausX = new ArrayList<>();
        //  for (int i =0 ; i < graus.length;i++){
        //     dataset.
        //   }


        double[] repetidos = new double[7];

        for (int i = 0; i < grausX.length; i++) {
            int cont = 0;
            for (int j = 0; j < grausDosEstados.length; j++) {

                if (grausX[i] == grausDosEstados[j] ) {

                  cont++;
                    //System.out.printf("O numero %d do vetor repeti %d vezes.\n", grausDosEstados[i], cont);

                }

            } repetidos[i] = cont;
        }

        HistogramDataset dataset = new HistogramDataset();

            dataset.setType(HistogramType.FREQUENCY);
            dataset.addSeries("Histo",grausDosEstados,8);
           // dataset.getXValue(i,grausX[i] );
           // dataset.getYValue(i,repetidos[i] );



        JFreeChart grafico = ChartFactory.createHistogram("Grafico Histograma", "Graus", "Frequencia dos Graus", (IntervalXYDataset) dataset,
                PlotOrientation.VERTICAL, true, false, false); // criacao do histograma

        //ChartPanel painelDOgrafico = new ChartPanel(grafico);
        try {
            System.out.println("Criando o Grafico...");


       // painelDOgrafico.setPreferredSize(new Dimension(400, 400));
       // painelDOgrafico.setVisible(true);
        //painelDOgrafico.show();
        OutputStream png = new FileOutputStream("GraficoSimples.png");

        ChartUtilities.writeChartAsPNG(png, grafico, 1000, 800);
        png.close();
         }catch (IOException io){
            System.out.println("Errei:" + io.getMessage());
        }





    }

}
