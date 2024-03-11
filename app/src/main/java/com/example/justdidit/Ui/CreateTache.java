package com.example.justdidit.Ui;

import android.content.Context;
import android.database.SQLException;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.justdidit.R;
import com.example.justdidit.Tache;
import com.example.justdidit.database.DAOSqlite;

import java.text.ParseException;
import java.util.Date;


 public class CreateTache extends AppCompatActivity {

        private EditText titreEDT;
        private EditText descEDT;
        private EditText dateDebutEDT;
        private EditText dateFinEDT;
        private TextView nombreDeJourTV;

     @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.creation_tache);

            titreEDT = findViewById(R.id.TitreEDT);
            descEDT = findViewById(R.id.DescEDT);
            dateDebutEDT = findViewById(R.id.editTextDate);
            dateFinEDT = findViewById(R.id.editTextDate2);
            nombreDeJourTV = findViewById(R.id.nombre_de_jour);
            Button enregistrerButton = findViewById(R.id.tacheEnregistrer);

            enregistrerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String titre = titreEDT.getText().toString();
                    String description = descEDT.getText().toString();

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date dateDebut;
                    Date dateFin;

                    try {
                        dateDebut = sdf.parse(dateDebutEDT.getText().toString());
                        dateFin = sdf.parse(dateFinEDT.getText().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                        // Handle the error, maybe notify the user that the date format is incorrect
                        return; // Exit the onClick method
                    }


                    Tache newTache = new Tache(titre, description, dateDebut, dateFin);

                    DAOSqlite dao = new DAOSqlite(CreateTache.this);

                    try {
                        dao.open();
                        long newId = dao.insertTache(newTache);
                        dao.close();
                        // The Tache is now inserted, and newId contains the new row ID.
                        // i should send this id to somewhere if i need


                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    nombreDeJourTV.setText(String.valueOf(newTache.getNombreJourRestant()) );
                }
            });
        }
    }
