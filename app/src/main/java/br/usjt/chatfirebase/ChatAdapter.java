package br.usjt.chatfirebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChatAdapter extends RecyclerView.Adapter{
    private List<br.usjt.chatfirebase.Mensagem> mensagens;
    private Context context;

    ChatAdapter(List<br.usjt.chatfirebase.Mensagem> mensagens, Context context){
        this.mensagens = mensagens;
        this.context = context;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.list_item, parent, false);
        return new ChatViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        br.usjt.chatfirebase.Mensagem m = mensagens.get(position);
        ChatViewHolder chatViewHolder = (ChatViewHolder)holder;
        chatViewHolder.dataNomeTextView.setText(context.getString(R.string.data_nome,
                br.usjt.chatfirebase.DateHelper.format(m.getData()), m.getUsuario()));
        chatViewHolder.mensagemTextView.setText((m.getTexto()));
    }

    @Override
    public int getItemCount() {
        return mensagens.size();
    }
}