package com.example.actividad_de_titulo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MotorAdapter extends RecyclerView.Adapter<MotorAdapter.MotorViewHolder> {
    private List<Motor> motorList;

    public MotorAdapter(List<Motor> motorList) {
        this.motorList = motorList;
    }

    @NonNull
    @Override
    public MotorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_motor, parent, false);
        return new MotorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MotorViewHolder holder, int position) {
        Motor motor = motorList.get(position);

        // Asignar datos a los TextViews
        holder.brandText.setText("Marca: " + motor.getMarca());
        holder.typeText.setText("Tipo: " + motor.getTipo());
        holder.kwText.setText("KW: " + motor.getKw());
        holder.a220Text.setText("A / 220: " + motor.getA220());
        holder.rpmText.setText("RPM: " + motor.getRpm());
        holder.nrText.setText("N. R.: " + motor.getNr());
        holder.pasoText.setText("Paso: " + motor.getPaso());
        holder.vBobText.setText("V / Bob: " + motor.getVBob());
        holder.diametroAlambreText.setText("Ø Alambre: " + motor.getDiametroAlambre());
        holder.conexText.setText("Conexión: " + motor.getConex());
        holder.dText.setText("D: " + motor.getD());
        holder.d2Text.setText("d: " + motor.getD2());
        holder.lText.setText("L: " + motor.getL());
        holder.prText.setText("P. R.: " + motor.getPr());
        holder.pCuKText.setText("P.cu/K: " + motor.getPCuK());
        holder.lBobText.setText("L / Bob: " + motor.getLBob());
        holder.muFText.setText("μ F: " + motor.getMuF());
    }

    @Override
    public int getItemCount() {
        return motorList.size();
    }

    public void updateList(List<Motor> filteredList) {
        motorList = filteredList;
        notifyDataSetChanged();
    }

    static class MotorViewHolder extends RecyclerView.ViewHolder {
        TextView brandText, typeText, kwText, a220Text, rpmText, nrText, pasoText, vBobText,
                diametroAlambreText, conexText, dText, d2Text, lText, prText, pCuKText, lBobText, muFText;

        public MotorViewHolder(@NonNull View itemView) {
            super(itemView);

            // Vincular los TextViews con el layout
            brandText = itemView.findViewById(R.id.textBrand);
            typeText = itemView.findViewById(R.id.textType);
            kwText = itemView.findViewById(R.id.textKw);
            a220Text = itemView.findViewById(R.id.textA220);
            rpmText = itemView.findViewById(R.id.textRpm);
            nrText = itemView.findViewById(R.id.textNr);
            pasoText = itemView.findViewById(R.id.textPaso);
            vBobText = itemView.findViewById(R.id.textVBob);
            diametroAlambreText = itemView.findViewById(R.id.textDiametroAlambre);
            conexText = itemView.findViewById(R.id.textConex);
            dText = itemView.findViewById(R.id.textD);
            d2Text = itemView.findViewById(R.id.textD2);
            lText = itemView.findViewById(R.id.textL);
            prText = itemView.findViewById(R.id.textPr);
            pCuKText = itemView.findViewById(R.id.textPCuK);
            lBobText = itemView.findViewById(R.id.textLBob);
            muFText = itemView.findViewById(R.id.textMuF);
        }
    }
}
