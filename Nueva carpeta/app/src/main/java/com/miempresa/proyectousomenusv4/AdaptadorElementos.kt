package com.miempresa.proyectousomenusv4

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class AdaptadorElementos (val ListaElementos:ArrayList<Elementos>):RecyclerView.Adapter<AdaptadorElementos.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val fTexto = itemView.findViewById<TextView>(R.id.elemento_texto)
        val fImagen = itemView.findViewById<ImageView>(R.id.elemento_imagen)
        val fDescripcion = itemView.findViewById<TextView>(R.id.descripcion)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdaptadorElementos.ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.elementoslista,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: AdaptadorElementos.ViewHolder, position: Int) {
        holder?.fTexto?.text=ListaElementos[position].texto
        holder?.fImagen?.setImageBitmap(ListaElementos[position].imagen)
        holder?.fDescripcion?.text=(ListaElementos[position].descripcion)

        holder.itemView.setOnCreateContextMenuListener{contextMenu, _, _ ->
            contextMenu.setHeaderTitle("Se eligio opcion "+ (position+1))
            true
        }
    }

    override fun getItemCount(): Int {
        return ListaElementos.size;
    }

}