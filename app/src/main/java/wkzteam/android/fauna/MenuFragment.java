package wkzteam.android.fauna;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;


public class MenuFragment extends Fragment {

    RecyclerView list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        ArrayList<Integer> animalAvatarList = new ArrayList<>();
        animalAvatarList.add(R.drawable.tiger);
        animalAvatarList.add(R.drawable.leopard);
        animalAvatarList.add(R.drawable.white_bear);
        animalAvatarList.add(R.drawable.kam_bear);
        animalAvatarList.add(R.drawable.whale);
        animalAvatarList.add(R.drawable.musk_deer);
        animalAvatarList.add(R.drawable.amur_goral);
        animalAvatarList.add(R.drawable.duck);
        animalAvatarList.add(R.drawable.harza);
        animalAvatarList.add(R.drawable.crane);
        animalAvatarList.add(R.drawable.stork);
        animalAvatarList.add(R.drawable.owl);
        animalAvatarList.add(R.drawable.sea_lion);

        list = view.findViewById(R.id.animalList);
        list.setLayoutManager(new GridLayoutManager(getContext(), 2));
        list.setAdapter(new CustomAdapterForAnimalList(animalAvatarList));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        requireActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    class CustomAdapterForAnimalList extends RecyclerView.Adapter<CustomAdapterForAnimalList.ViewHolder> {

        List<Integer> animalAvatarList;

        private CustomAdapterForAnimalList(List<Integer> animalAvatarList) {
           this.animalAvatarList = animalAvatarList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.animal_list_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.animalAvatar.setImageResource(animalAvatarList.get(position));
            holder.animalListItem.setOnClickListener(view -> {
                Bundle animalIdBundle = new Bundle();
                animalIdBundle.putInt("animalId", position);
                Navigation.findNavController(requireActivity(), R.id.container)
                        .navigate(R.id.action_menuFragment_to_animalInfoFragment, animalIdBundle);
            });
        }

        @Override
        public int getItemCount() {
            return animalAvatarList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView animalAvatar;
            CardView animalListItem;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                animalAvatar = itemView.findViewById(R.id.animalAvatar);
                animalListItem = itemView.findViewById(R.id.animalListItem);
            }
        }
    }
}