import java.util.PriorityQueue;
import java.util.Queue;
import java.util.*;
import java.lang.Math;


public class Codigo
{
    PriorityQueue<OrdenarCaracterConPx> Arboles = new PriorityQueue<OrdenarCaracterConPx>();

    String[] OrdenCodigoHuffman = new String[256]; 
    String[] OrdenCaracters = new String[256]; 
    int[] OrdenFinal = new int[256];
    double[] PxFinal = new double[256]; 
    double[] log = new double[256]; 
    double[] PxLog = new double[256]; 
    double[] nPx = new double[256]; 
    double suma1=0;
    double suma2=0;
    double porcentaje=0;

    int i=0;

    public OrdenarCaracterConPx AsignacionDatos(double[] Px, int Limite, String[] Caracteres, int[] Cont) 
    {

        for (int i = 0; i < Limite; i++)
        {
            Arboles.add(new GenerarHojaConCaracter(Cont[i], Caracteres[i]));
            PxFinal[i] = Px[i];
        }

        while (Arboles.size() > 1) 
        {
            //devuelve el siguiente nodo de la cola o NULL si no tiene más
            OrdenarCaracterConPx a = Arboles.poll();
            //devuelve el siguiente nodo de la cola o NULL si ya no tiene más
            OrdenarCaracterConPx b = Arboles.poll();
            //Se va creando los sub-arboles binarios
            Arboles.add(new ValorAnterior(a, b)); 
        }
        //Devuelve el primer nodo del árbol
        return Arboles.poll();
    }

    public void GenerarCodigo(OrdenarCaracterConPx Arbol, StringBuffer Cod) 
    {
        
        if (Arbol instanceof GenerarHojaConCaracter) 
        {
            GenerarHojaConCaracter Hoja = (GenerarHojaConCaracter)Arbol;
            OrdenCodigoHuffman[i] = Cod.toString();
            OrdenCaracters[i] = Hoja.Letra;
            OrdenFinal[i] = Hoja.Veces;
            i++;
        } 
        else if (Arbol instanceof ValorAnterior) 
        {
            ValorAnterior Nodo = (ValorAnterior)Arbol;
            Cod.append('0');
            GenerarCodigo(Nodo.valorAIzquierda, Cod);
            Cod.deleteCharAt(Cod.length()-1);
 
            Cod.append('1');
            GenerarCodigo(Nodo.valorADerecha, Cod);
            Cod.deleteCharAt(Cod.length()-1);
        }
    }
    public void reordenarFinal()
    {
        for (int k = 0 ; k < i - 1 ; k++) 
        {
            int max = k;
            //buscamos el mayor número
            if(OrdenFinal[k]>0)
            {
            for (int j = k + 1 ; j < i ; j++) 
            {
                    if (OrdenFinal[j] > OrdenFinal[max]) 
                    {
                        max = j; //encontramos el mayor número
                    }
            }
 
                if (k != max) {
                //permutamos los valores
                int aux = OrdenFinal[k];
                String PalabraS = OrdenCaracters[k];
                String PxS = OrdenCodigoHuffman[k];

                OrdenFinal[k] = OrdenFinal[max];
                OrdenFinal[max] = aux;

                OrdenCaracters[k] = OrdenCaracters[max];
                OrdenCaracters[max] = PalabraS;

                OrdenCodigoHuffman[k] = OrdenCodigoHuffman[max];
                OrdenCodigoHuffman[max] = PxS;
            }
            }
        }

        for (int k = 0 ; k < i; k++) 
        {
        log[k]=Math.log10(1/PxFinal[k])/Math.log10(2.);
        PxLog[k]=PxFinal[k]*(Math.log10(1/PxFinal[k])/Math.log10(2.));
        nPx[k]=OrdenFinal[k]*PxFinal[k];
        suma1+=PxLog[k];
        suma2+=nPx[k];
        }
        porcentaje = (suma2/suma1)*100;
    }
    public double[] FinalProbabilidad()
    {
        return PxFinal;
    }
    public String[] FinalCodigo()
    {
        return OrdenCodigoHuffman;
    }
    public String[] FinalCaracter()
    {
        return OrdenCaracters;
    }
    public int[] FinalConteo()
    {
        return OrdenFinal;
    }
    public double[] Finallog()
    {
        return log;
    }
    public double[] FinalPxLog()
    {
        return PxLog;
    }
    public double[] FinalnPx()
    {
        return nPx;
    }
    public double FinalnPorcentaje()
    {
        return porcentaje;
    }
    public double FinalSuma1()
    {
        return suma1;
    }
    public double FinalSuma2()
    {
        return suma2;
    }
    public int Finali()
    {
        return i;
    }
}