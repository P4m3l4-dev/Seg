package br.com.pamela.moblie.seg.ui.credencial;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.pamela.moblie.seg.databinding.FragmentConCredencialBinding;
import br.com.pamela.moblie.seg.model.Usuario;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Usuario}.
 * TODO: Replace the implementation with code for your data type.
 */
public class UsuarioRecyclerViewAdapter extends RecyclerView.Adapter<UsuarioRecyclerViewAdapter.ViewHolder> {

    private final List<Usuario> mValues;

    public UsuarioRecyclerViewAdapter(List<Usuario> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentConCredencialBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getNome());
        holder.mContentView.setText(mValues.get(position).getTelefone());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public Usuario mItem;

        public ViewHolder(FragmentConCredencialBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}