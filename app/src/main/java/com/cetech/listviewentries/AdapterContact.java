package com.cetech.listviewentries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cetech.listviewentries.model.Contact;

import java.util.List;

/**
 * Created by oemy9 on 08/04/2018.
 */

public class AdapterContact extends BaseAdapter {

    private List <Contact> mListContacts;
    private Context mContext;

    public AdapterContact (
            Context context,
            List <Contact> mListContacts) {

        this.mContext = context;
        this.mListContacts = mListContacts;

    }

    @Override
    public int getCount () {
        return mListContacts.size();
    }

    @Override
    public Contact getItem (int position) {
        return mListContacts.get(position);
    }

    @Override
    public long getItemId (int i) {
        return 0;
    }

    @Override
    public View getView (int position, View view, ViewGroup viewGroup) {
        //DEFINIMOS INFLATER
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        //INDICAMOS QUE RECURSO LAYOUT USAREMOS
        view = mInflater.inflate(R.layout.item_contact, viewGroup, false);
        //FINDVIEWS
        TextView tvContactName = view.findViewById(R.id.tv_contact_name);
        TextView tvContactPhone = view.findViewById(R.id.tv_contact_phone);
        TextView tvContactEmail = view.findViewById(R.id.tv_contact_email);
        ImageView ivContactPhoto = view.findViewById(R.id.iv_contact_photo);

        //CONTACTO DE ACUERDO A LA POSICIÒN ACTUAL
        Contact itemContact = mListContacts.get(position);

        //SETEAR INFORMACIÒN
        ivContactPhoto.setImageResource(itemContact.getPhoto());
        tvContactName.setText(itemContact.getName());
        tvContactPhone.setText(itemContact.getPhone());
        tvContactEmail.setText(itemContact.getEmail());

        return view;
    }
}
