package MLT.sudoku;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import MLT.sudoku.dataBase.GameLevel;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private List<GameLevel> gameList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView gameIdList;
        public TextView gameState;

        public MyViewHolder(View view) {
            super(view);
            gameIdList = view.findViewById(R.id.item_textView_lvl_number);
            gameState = view.findViewById(R.id.item_textView_game_state);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.level_item, parent, false);

        return new MyViewHolder(itemView);
    }

    public RecyclerViewAdapter(Context context, List<GameLevel> games){
        this.context = context;
        this.gameList = games;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Resources  resources = context.getResources();
        holder.gameIdList.setText(resources.getString(R.string.item_level_selection_text_level)
                + " " + (position + 1));
        if(gameList.get(position).getLevel_state() == 1){
            holder.gameState.setText(resources
                    .getString(R.string.item_level_selection_text_continue));
        }
        else if(gameList.get(position).getLevel_state() == 0){
            holder.gameState.setText(resources
                    .getString(R.string.item_level_selection_text_start));
        }
        else{
            holder.gameState.setText(resources.getString(R.string.item_level_selection_text_solved));
        }
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }


}
