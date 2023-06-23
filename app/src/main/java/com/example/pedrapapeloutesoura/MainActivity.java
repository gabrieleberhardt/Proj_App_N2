package com.example.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Metodos para pegar a opção selcionada, onde o user clicou.
    public void selecionadoPedra(View view) {this.opcaoSelecionada("pedra"); }
    //evento onClick view,chamando metodo android:onClick="selecionadoPedra";
    //passa o parametro pedra para o metodo opcaoSelecionada;
    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }
    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }
    public void selecionadoReset(View view){ this.opcaoSelecionada("reset");}


    //Aqui acontece o Jogo
    @SuppressLint("SetTextI18n")
    public void opcaoSelecionada(String escolhaUsuario) {

        ImageView imageResultado = findViewById(R.id.imageResultado);
        //findViewById que captura/retorna o componente da tela;
        TextView textoResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);//0 1 2 gera/sorteia um numero aleatório;
        String[] opcoes = {"pedra", "papel", "tesoura"};//Array de opções onde respectivamente 0, 1, 2;
        String escolhaApp = opcoes [ numero ];//config do array,pega as opções pelo nr aleatório do Random;

        switch (escolhaApp) { //se for pedra mostra pedra, papel mostra o papel....
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;

            case "papel":
                imageResultado.setImageResource(R.drawable.papel);//recebe uma nova img da pasta drawable
                break;

            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;

        }
        //System.out.println("Item clicado" + opcaoApp);

        //Comparação escolha do jogador Vs escolha da maquina;
        if (
                (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
                (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                (escolhaApp == "pedra" && escolhaUsuario == "tesoura")
        ) //app ganhador
             {textoResultado.setText("Você perdeu :( ");        }

        else if (
                (escolhaUsuario == "tesoura" && escolhaApp == "papel") ||
                (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                (escolhaUsuario == "pedra" && escolhaApp == "tesoura")
        )  //usuario ganhador
            {textoResultado.setText("Você Ganhou :) ");}

        else if (
                (escolhaUsuario == "reset")
        )
        {imageResultado.setImageResource(R.drawable.android);
            textoResultado.setText("Jogo reiniciado!");}

        else  {
            textoResultado.setText("Empatamos ;) ");
        }





    }
}
