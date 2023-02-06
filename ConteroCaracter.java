public class ConteroCaracter
{
    //Texto insertado
    String Texto;

    //Arreglos para el conteo de los caracteres del texto insertado
    int[] contador = new int[256]; 
    String[] Palabra = new String[256]; 
    double[] Px = new double[256];

    //Arreglos que guardaran en orden descendente los valores de cada caracter que ayudara a guardar el num de letras, la Probabibilidad y el num de los caracteres que hay en en el texto
    int[] ContadorFinal = new int[256]; 
    double[] PxFinal = new double[256];
    String[] CaracterOrdenado = new String[256]; 

    //Contador para saber el indice del arreglo final
    int cont=0;

    //Metodo que Esta referencia se usa para pasar la referencia al objeto actual como un parámetro para otros métodos.     
    public ConteroCaracter(String Texto) 
    {
        this.Texto = Texto;
    }

    //Metodo que Retorna si se requiere el Valor ingresado
    public String getNombre() 
    {
        return Texto;
    }

    //Metodo que hace referencia al valor actual ingresado para poder trabajar con el texto
    public void setNombre(String Texto) 
    {
        this.Texto = Texto;
    }

    //Metodo que contara el num de caracteres que hay en el texto insertado
    public void contarNumCaracteres()
    {
        int numeroCaracter=0;
        char letra=0;
        String  Caracteres="";
        //Obtemos la logitud final de la cadena insertada
        numeroCaracter=Texto.length();
        //For que asigna todos los caracteres del codigo ascii a una cadena
        for(int i=0; i<=255 ; i++ )
        {
            Caracteres+=(letra++); //se asignan los caracteres del codigo ascii
        }
        //For que recorre la cadena recibida letra a letra
        for(int i=0;i<Texto.length();i++)
        {
            // recorremos la palabra ingresada para comparar con cada una de las letras del codigo ascii con la del texto insertado
            for(int j=0;j<Caracteres.length();j++)
            {
                if(Texto.charAt(i)==Caracteres.charAt(j))
                {
                    // aumentamos el contador para la letra que coincidan
                    contador[j]++;
                }
            }
        }

        
        for(int i=0;i<Caracteres.length();i++)
        {
            if(contador[i]>0)
            {
                //Se obtiene la probabilidad de cada caracter
                Px[i] = (contador[i]*1.0/numeroCaracter*1.0);
                Palabra[i]=String.valueOf(Caracteres.charAt(i));
            }
        }

        OrdenDescendenteCaracterPx();
        
        //Reagcionamos a un arreglo los caractes junto su probabilidad de cada caracter
        //Asignacion de los elementos a un arreglo nuevo
        for(int i=0;i<Caracteres.length();i++)
        {
            if(contador[i]>0)
            {
                CaracterOrdenado[cont] = Palabra[i];
                ContadorFinal[cont] = contador[i];
                PxFinal[cont] = Px[i];
                cont++;
            }
        }
    }

    public void OrdenDescendenteCaracterPx()
    {
        for (int i = 0 ; i < contador.length - 1 ; i++) 
        {
            int max = i;
            //buscamos el mayor número
            if(contador[i]>0)
            {
            for (int j = i + 1 ; j < contador.length ; j++) 
            {
                    if (contador[j] > contador[max]) 
                    {
                        max = j; //encontramos el mayor número
                    }
            }
 
                if (i != max) {
                //permutamos los valores
                int aux = contador[i];
                String PalabraS = Palabra[i];
                double PxS = Px[i];

                contador[i] = contador[max];
                contador[max] = aux;

                Palabra[i] = Palabra[max];
                Palabra[max] = PalabraS;

                Px[i] = Px[max];
                Px[max] = PxS;
            }
            }
        }
    }
    //Metodo que Retorna si se requiere el Valor ingresado
    public double[] getPx() 
    {
        return PxFinal;
    }
    //Metodo que Retorna si se requiere el Valor ingresado
    public String[]  getCaracter() 
    {
        return CaracterOrdenado;
    }
    //Metodo que Retorna si se requiere el Valor ingresado
    public int[]  getConteo() 
    {
        return ContadorFinal;
    }
    //Metodo que Retorna si se requiere el Valor ingresado
    public int  getLimite() 
    {
        return cont;
    }

}