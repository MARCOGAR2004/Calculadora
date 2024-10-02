package edu.upc.marcog.calculadoramain;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int angulo;

    private TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.texto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Escribir(View view)
    {
        Button button = (Button) view;
        String textoBoton = button.getText().toString();
        String textoActual = texto.getText().toString();
        if (textoActual.equals("0"))
        {
            texto.setText(textoBoton);
        }
        else
        {
          textoActual = textoActual + textoBoton;
          texto.setText(textoActual);
        }

    }
    public void Resolver(View view)
    {
      double n1 = 0;
      double n2 = 0;
      String numero1 = "0";
      String numero2 = "0";
      char simbolo = '0';
      double resultado = 0;
      char sincos = '0';
      String operacion = texto.getText().toString();
      char[] caracteres = operacion.toCharArray();
      int i = 0;
      while(i < caracteres.length)
      {
        if ((caracteres[i] == '+')||(caracteres[i] == '-')||(caracteres[i] == 'x')||(caracteres[i] == '/'))
        {
            if (sincos == '0')
            {
                if (simbolo == '0')
                {
                    simbolo = caracteres[i];

                }
                else
                {
                    n1 = Double.parseDouble(numero1);
                    n2 = Double.parseDouble(numero2);
                    if (simbolo == '+')
                    {
                        if (resultado == 0)
                        {
                            resultado = n1 + n2;
                        }
                        else
                        {
                            resultado = resultado + n2;
                        }
                    }
                    if (simbolo == '-')
                    {
                        if (resultado == 0)
                        {
                            resultado = n1 - n2;
                        }
                        else
                        {
                            resultado = resultado - n2;
                        }
                    }
                    if (simbolo == 'x')
                    {
                        if (resultado == 0)
                        {
                            resultado = n1 * n2;
                        }
                        else
                        {
                            resultado = resultado * n2;
                        }
                    }
                    if (simbolo == '/')
                    {
                        if (resultado == 0)
                        {
                            resultado = n1 / n2;
                        }
                        else
                        {
                            resultado = resultado / n2;
                        }
                    }
                    numero2 = "0";
                    simbolo = caracteres[i];

                }
            }
            else
            {
                n1 = Double.parseDouble(numero1);
                n2 = Double.parseDouble(numero2);
                if (angulo == 1)
                {
                    n1 = n1*180/3.14;
                    n2 = n2*180/3.14;
                }
                if (sincos == 's')
                {
                    if (n2 == 0)
                    {
                        n1 = Math.sin(n1);
                    }
                    else
                    {
                        n2 = Math.sin(n2);
                    }
                }
                if (sincos == 'c')
                {
                    if (n2 == 0)
                    {
                        n1 = Math.cos(n1);
                    }
                    else
                    {
                        n2 = Math.cos(n2);
                    }
                }
                if (sincos == 't')
                {
                    if (n2 == 0)
                    {
                        n1 = Math.tan(n1);
                    }
                    else
                    {
                        n2 = Math.tan(n2);
                    }
                }
            }
        }
        else if((caracteres[i] == 's')||(caracteres[i] == 'c')||(caracteres[i] == 't'))
        {
            if (caracteres[i] == 's')
            {
                sincos = 's';
            }
            else if (caracteres[i] == 'c')
            {
                sincos = 'c';
            }
            else if (caracteres[i] == 't')
            {
                sincos = 't';
            }
            i = i + 2;
        }
        else
        {
            if ((numero1.equals("0")) && (simbolo == '0'))
            {
                numero1 = "" + caracteres[i];
            }
            else if ((!numero1.equals("0")) && (simbolo == '0'))
            {
                numero1 = numero1 + caracteres[i];
            }
            else if ((!numero1.equals("0")) && (simbolo != '0') &&(numero2.equals("0")))
            {
                numero2 = "" + caracteres[i];
            }
            else if ((!numero1.equals("0")) && (simbolo != '0') && (!numero2.equals("0")))
            {
                numero2 = numero2 + caracteres[i];
            }
        }
        i++;
      }

            n1 = Double.parseDouble(numero1);
            n2 = Double.parseDouble(numero2);

            switch (simbolo) {
                case '+':
                    if (resultado == 0) {
                        resultado = n1 + n2;
                    } else {
                        resultado = resultado + n2;
                    }
                    break;
                case '-':
                    if (resultado == 0) {
                        resultado = n1 - n2;
                    } else {
                        resultado = resultado - n2;
                    }
                    break;
                case 'x':
                    if (resultado == 0) {
                        resultado = n1 * n2;
                    } else {
                        resultado = resultado * n2;
                    }
                    break;
                case '/':
                    if (n2 != 0) {
                        if (resultado == 0) {
                            resultado = n1 / n2;
                        } else {
                            resultado = resultado / n2;
                        }


                    } else {
                        texto.setText("Error: División por cero");
                        return;
                    }
                    break;
                case '0':
                    if (angulo == 1)
                    {
                        n1 = n1*180/3.14;
                        n2 = n2*180/3.14;
                    }
                    if (sincos == 's')
                    {
                        if (n2 == 0) {
                            resultado = Math.sin(n1);
                        } else {
                            n2 = Math.sin(n2);
                        }
                    }
                    if (sincos == 'c')
                    {
                        if (n2 == 0)
                        {
                            resultado = Math.cos(n1);
                        }
                        else
                        {
                            n2 = Math.cos(n2);
                        }
                    }

                    if (sincos == 't')
                    {
                        if (n2 == 0)
                        {
                            resultado = Math.tan(n1);
                        }
                        else
                        {
                            n2 = Math.tan(n2);
                        }
                    }
                    break;
            }

      texto.setText(String.valueOf(resultado));
    }

    public void Vaciar(View view)
    {
        texto.setText("0");
    }

    public void Angulo(View view)
    {
        if (angulo == 0)
        {
            angulo = 1;
        }
        else if (angulo == 1)
        {
            angulo = 0;
        }
    }

}