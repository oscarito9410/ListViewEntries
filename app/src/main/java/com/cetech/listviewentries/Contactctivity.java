package com.cetech.listviewentries;

import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cetech.listviewentries.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class Contactctivity extends AppCompatActivity {

    ListView listContacts;
    private AdapterContact adapterContact;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactctivity);
        listContacts = findViewById(R.id.list_contacts);

        listContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView <?> adapterView, View view, int position, long l) {

                final Contact selectedContact = adapterContact.getItem(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(Contactctivity.this);
                builder.setTitle("Elige una opciòn");
                builder.setItems(new CharSequence[]{"Llamar", "Enviar email", "Busqueda en google"},
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick (DialogInterface dialogInterface, int option) {
                                switch (option) {
                                    case 0: {
                                        Intent i = new Intent(Intent.ACTION_DIAL);
                                        i.setData(Uri.parse("tel:" + selectedContact.getPhone()));
                                        startActivity(i);
                                        break;
                                    }
                                    case 1:
                                        try {
                                            Intent i = new Intent(Intent.ACTION_SENDTO,
                                                    Uri.fromParts("mailto",
                                                            selectedContact.getEmail(), null));
                                            startActivity(i);
                                        } catch (ActivityNotFoundException e) {
                                            e.printStackTrace();
                                        }
                                        break;

                                    case 2: {
                                        Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
                                        i.putExtra(SearchManager.QUERY, selectedContact.getName());
                                        startActivity(i);
                                    }

                                }
                            }
                        });

                builder.create().show();

            }
        });

        setAdapter();
    }

    private void setAdapter () {
        adapterContact = new
                AdapterContact(this, getDummyContacts());

        listContacts.setAdapter(adapterContact);

    }

    private List <Contact> getDummyContacts () {
        List <Contact> list = new ArrayList <>();
        list.add(new Contact(
                "Oscar Pèrez",
                "552010301",
                "oscar12094@gmail.com",
                R.drawable.ct_man));

        list.add(new Contact("Juan",
                "6612912029",
                "juan212@gmail.com", R.drawable.ct_man_dos));

        list.add(new Contact("Diana", "5526381099",
                "diana@hotmail.com", R.drawable.ct_girl));

        list.add(new Contact("Lizbeth", "55182912",
                "lizbeth@gmail.com", R.drawable.ct_girl_dos));

        return list;
    }


}
