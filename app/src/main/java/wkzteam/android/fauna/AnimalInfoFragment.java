package wkzteam.android.fauna;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerTracker;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;


public class AnimalInfoFragment extends Fragment {

    RecyclerView animalInfoList;
    TextView animalNameInfo;
    YouTubePlayerView player;
    YouTubePlayerListener youTubePlayerListener;
    YouTubePlayerTracker tracker;
    SharedPreferences pref;

    int animalId;
    float lastDuration;

    final String TIGER_URI = "XWgiuQfCWk0";
    final String LEOPARD_URI = "NkfQY4mw2o4";
    final String WHITE_BEAR_URI = "MoSSf06Gnc8";
    final String KAM_BEAR_URI = "Rp8i_xBlos4";
    final String WHALE_URI = "K5NhSF8U7co";
    final String MUSK_DEER_URI = "K_kPv0G4F4M";
    final String GORAL_URI = "";
    final String DUCK_URI = "RA7dba4x9Gg";
    final String HARZA_URI = "cDnn_wqObXo";
    final String CRANE_URI = "xDfcAFTuXC0";
    final String STORK_URI = "0mXYMsi9288";
    final String OWL_URI = "Ch6MpfAtIWI";
    final String SEA_LION_URI = "v2Fv9iNp5y4";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animal_info, container, false);

        pref = requireContext().getSharedPreferences("videoDuration", Context.MODE_PRIVATE);

        assert getArguments() != null;
        animalId = getArguments().getInt("animalId");


        initRecyclerView(view);

        animalNameInfo = view.findViewById(R.id.animalNameInfo);
        tracker = new YouTubePlayerTracker();

        setText(animalId);

        player = view.findViewById(R.id.player);
        getLifecycle().addObserver(player);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getScreenOrientation();

        youTubePlayerListener = new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
                youTubePlayer.addListener(tracker);
                setUri(animalId, youTubePlayer);
            }
        };
        player.addFullScreenListener(new YouTubePlayerFullScreenListener() {
            @Override
            public void onYouTubePlayerEnterFullScreen() {
                requireActivity().setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }

            @Override
            public void onYouTubePlayerExitFullScreen() {
                requireActivity().setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        });
        player.initialize(youTubePlayerListener);
    }

    @Override
    public void onPause() {
        super.onPause();
        switch (animalId) {
            case 0:
                pref.edit().putFloat("tigerCurrentSecond", tracker.getCurrentSecond()).apply();
                break;
            case 1:
                pref.edit().putFloat("leopardCurrentSecond", tracker.getCurrentSecond()).apply();
                break;
            case 2:
                pref.edit().putFloat("whiteBearCurrentSecond", tracker.getCurrentSecond()).apply();
                break;
            case 3:
                pref.edit().putFloat("kamBearCurrentSecond", tracker.getCurrentSecond()).apply();
                break;
            case 4:
                pref.edit().putFloat("whaleCurrentSecond", tracker.getCurrentSecond()).apply();
                break;
            case 5:
                pref.edit().putFloat("muskDeerCurrentSecond", tracker.getCurrentSecond()).apply();
                break;
            case 6:
                pref.edit().putFloat("goralCurrentSecond", tracker.getCurrentSecond()).apply();
                break;
            case 7:
                pref.edit().putFloat("duckCurrentSecond", tracker.getCurrentSecond()).apply();
                break;
            case 8:
                pref.edit().putFloat("harzaCurrentSecond", tracker.getCurrentSecond()).apply();
                break;
            case 9:
                pref.edit().putFloat("craneCurrentSecond", tracker.getCurrentSecond()).apply();
                break;
            case 10:
                pref.edit().putFloat("storkCurrentSecond", tracker.getCurrentSecond()).apply();
                break;
            case 11:
                pref.edit().putFloat("owlCurrentSecond", tracker.getCurrentSecond()).apply();
                break;
            case 12:
                pref.edit().putFloat("seaLionCurrentSecond", tracker.getCurrentSecond()).apply();
                break;
            default:break;
        }
    }

    public void setUri(int animalId, YouTubePlayer youTubePlayer) {
        switch (animalId) {
            case 0:
                lastDuration = pref.getFloat("tigerCurrentSecond", 0);
                youTubePlayer.loadVideo(TIGER_URI, lastDuration);
                break;
            case 1:
                lastDuration = pref.getFloat("leopardCurrentSecond", 0);
                youTubePlayer.loadVideo(LEOPARD_URI, lastDuration);
                break;
            case 2:
                lastDuration = pref.getFloat("whiteBearCurrentSecond", 0);
                youTubePlayer.loadVideo(WHITE_BEAR_URI, lastDuration);
                break;
            case 3:
                lastDuration = pref.getFloat("kamBearCurrentSecond", 0);
                youTubePlayer.loadVideo(KAM_BEAR_URI, lastDuration);
                break;
            case 4:
                lastDuration = pref.getFloat("whaleCurrentSecond", 0);
                youTubePlayer.loadVideo(WHALE_URI, lastDuration);
                break;
            case 5:
                lastDuration = pref.getFloat("muskDeerCurrentSecond", 0);
                youTubePlayer.loadVideo(MUSK_DEER_URI, lastDuration);
                break;
            case 6:
                lastDuration = pref.getFloat("goralCurrentSecond", 0);
                youTubePlayer.loadVideo(GORAL_URI, lastDuration);
                break;
            case 7:
                lastDuration = pref.getFloat("duckCurrentSecond", 0);
                youTubePlayer.loadVideo(DUCK_URI, lastDuration);
                break;
            case 8:
                lastDuration = pref.getFloat("harzaCurrentSecond", 0);
                youTubePlayer.loadVideo(HARZA_URI, lastDuration);
                break;
            case 9:
                lastDuration = pref.getFloat("craneCurrentSecond", 0);
                youTubePlayer.loadVideo(CRANE_URI, lastDuration);
                break;
            case 10:
                lastDuration = pref.getFloat("storkCurrentSecond", 0);
                youTubePlayer.loadVideo(STORK_URI, lastDuration);
                break;
            case 11:
                lastDuration = pref.getFloat("owlCurrentSecond", 0);
                youTubePlayer.loadVideo(OWL_URI, lastDuration);
                break;
            case 12:
                lastDuration = pref.getFloat("seaLionCurrentSecond", 0);
                youTubePlayer.loadVideo(SEA_LION_URI, lastDuration);
                break;
            default:break;
        }
    }

    public void setText(int animalId) {
        switch (animalId) {
            case 0:
                animalNameInfo.setText(R.string.tiger);
                break;
            case 1:
                animalNameInfo.setText(R.string.leopard);
                break;
            case 2:
                animalNameInfo.setText(R.string.white_bear);
                break;
            case 3:
                animalNameInfo.setText(R.string.b_bear);
                break;
            case 4:
                animalNameInfo.setText(R.string.whale);
                break;
            case 5:
                animalNameInfo.setText(R.string.musk_deer);
                break;
            case 6:
                animalNameInfo.setText(R.string.amur_goral);
                break;
            case 7:
                animalNameInfo.setText(R.string.duck);
                break;
            case 8:
                animalNameInfo.setText(R.string.harza);
                break;
            case 9:
                animalNameInfo.setText(R.string.crane);
                break;
            case 10:
                animalNameInfo.setText(R.string.stork);
                break;
            case 11:
                animalNameInfo.setText(R.string.owl);
                break;
            case 12:
                animalNameInfo.setText(R.string.sea_lion);
                break;
            default:break;
        }
    }

    private void getScreenOrientation(){
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            player.toggleFullScreen();
        }
    }

    private void initRecyclerView(View view) {
        ArrayList<Integer> infoArrayTitle = new ArrayList<>();
        infoArrayTitle.add(R.string.type_of_food);
        infoArrayTitle.add(R.string.population);
        infoArrayTitle.add(R.string.area);
        infoArrayTitle.add(R.string.classification);

        ArrayList<Integer> infoArraySubTitle = new ArrayList<>();
        switch (animalId) {
            case 0:
                infoArraySubTitle.add(R.string.predator);
                infoArraySubTitle.add(R.string.tiger_population);
                infoArraySubTitle.add(R.string.tiger_areal);
                infoArraySubTitle.add(R.string.tiger_classification);
                break;
            case 1:
                infoArraySubTitle.add(R.string.predator);
                infoArraySubTitle.add(R.string.leopard_population);
                infoArraySubTitle.add(R.string.leopard_areal);
                infoArraySubTitle.add(R.string.leopard_classification);
                break;
            case 2:
                infoArraySubTitle.add(R.string.predator);
                infoArraySubTitle.add(R.string.white_bear_population);
                infoArraySubTitle.add(R.string.white_bear_areal);
                infoArraySubTitle.add(R.string.white_bear_classification);
                break;
            case 3:
                infoArraySubTitle.add(R.string.predator);
                infoArraySubTitle.add(R.string.b_bear_population);
                infoArraySubTitle.add(R.string.b_bear_areal);
                infoArraySubTitle.add(R.string.b_bear_classification);
                break;
            case 4:
                infoArraySubTitle.add(R.string.predator);
                infoArraySubTitle.add(R.string.whale_population);
                infoArraySubTitle.add(R.string.whale_areal);
                infoArraySubTitle.add(R.string.whale_classification);
                break;
            case 5:
                infoArraySubTitle.add(R.string.herbivore);
                infoArraySubTitle.add(R.string.musk_deer_population);
                infoArraySubTitle.add(R.string.musk_deer_areal);
                infoArraySubTitle.add(R.string.musk_deer_classification);
                break;
            case 6:
                infoArraySubTitle.add(R.string.herbivore);
                infoArraySubTitle.add(R.string.amur_goral_population);
                infoArraySubTitle.add(R.string.amur_goral_areal);
                infoArraySubTitle.add(R.string.amur_goral_classification);
                break;
            case 7:
                infoArraySubTitle.add(R.string.all_eat);
                infoArraySubTitle.add(R.string.duck_population);
                infoArraySubTitle.add(R.string.duck_areal);
                infoArraySubTitle.add(R.string.duck_classification);
                break;
            case 8:
                infoArraySubTitle.add(R.string.predator);
                infoArraySubTitle.add(R.string.harza_population);
                infoArraySubTitle.add(R.string.harza_areal);
                infoArraySubTitle.add(R.string.harza_classification);
                break;
            case 9:
                infoArraySubTitle.add(R.string.all_eat);
                infoArraySubTitle.add(R.string.crane_population);
                infoArraySubTitle.add(R.string.crane_areal);
                infoArraySubTitle.add(R.string.crane_classification);
                break;
            case 10:
                infoArraySubTitle.add(R.string.predator);
                infoArraySubTitle.add(R.string.stork_population);
                infoArraySubTitle.add(R.string.stork_areal);
                infoArraySubTitle.add(R.string.stork_classification);
                break;
            case 11:
                infoArraySubTitle.add(R.string.predator);
                infoArraySubTitle.add(R.string.owl_population);
                infoArraySubTitle.add(R.string.owl_areal);
                infoArraySubTitle.add(R.string.owl_classification);
                break;
            case 12:
                infoArraySubTitle.add(R.string.predator);
                infoArraySubTitle.add(R.string.sea_lion_population);
                infoArraySubTitle.add(R.string.sea_lion_areal);
                infoArraySubTitle.add(R.string.sea_lion_classification);
                break;
        }

        animalInfoList = view.findViewById(R.id.animalInfoList);
        animalInfoList.setLayoutManager(new GridLayoutManager(getContext(), 2));
        animalInfoList.setAdapter(new CustomAdapterForAnimalInfoList(infoArrayTitle, infoArraySubTitle));
    }

    private class CustomAdapterForAnimalInfoList extends RecyclerView.Adapter<CustomAdapterForAnimalInfoList.ViewHolder> {

        List<Integer> infoTitleArray;
        List<Integer> infoArraySubTitle;

        private CustomAdapterForAnimalInfoList(List<Integer> infoTitleArray, List<Integer> infoArraySubTitle) {
            this.infoTitleArray = infoTitleArray;
            this.infoArraySubTitle = infoArraySubTitle;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.animal_info_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.infoTextTitle.setText(infoTitleArray.get(position));
            holder.infoTextSubtitle.setText(infoArraySubTitle.get(position));
        }

        @Override
        public int getItemCount() {
            return infoTitleArray.size();
        }

        private class ViewHolder extends RecyclerView.ViewHolder {

            TextView infoTextTitle;
            TextView infoTextSubtitle;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                infoTextTitle = itemView.findViewById(R.id.infoTextTitle);
                infoTextSubtitle = itemView.findViewById(R.id.infoTextSubtitle);
            }
        }
    }
}