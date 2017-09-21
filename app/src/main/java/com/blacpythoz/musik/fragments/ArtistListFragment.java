package com.blacpythoz.musik.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blacpythoz.musik.R;
import com.blacpythoz.musik.adapters.ArtistAdapter;
import com.blacpythoz.musik.models.ArtistModel;
import com.blacpythoz.musik.services.MusicService;

import java.util.ArrayList;

/**
 * Created by deadsec on 9/3/17.
 */

public class ArtistListFragment extends MusicServiceFragment {

    MusicService musicService;
    RecyclerView recyclerView;
    ArtistAdapter artistAdapter;
    ArrayList<ArtistModel> artists;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artist_list,container,false);
        recyclerView =  view.findViewById(R.id.rv_artist_list);
        artists = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        artistAdapter = new ArtistAdapter(artists,getContext());
        return view;
    }

    @Override
    public void onServiceConnected(MusicService musicService) {
        this.musicService = musicService;
        initPlayer();
    }

    public void initPlayer() {
            artists = musicService.getArtists();
            artistAdapter = new ArtistAdapter(artists, getContext());
            recyclerView.setAdapter(artistAdapter);
    }

}
