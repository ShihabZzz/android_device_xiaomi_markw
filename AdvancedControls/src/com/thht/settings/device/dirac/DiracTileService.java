package com.thht.settings.device.dirac;

import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

public class DiracTileService extends TileService {

    private AudioEnhancerUtils mUtils;

    @Override
    public void onStartListening() {

        mUtils = new AudioEnhancerUtils();

        boolean enhancerEnabled = mUtils.isEnabled(getApplicationContext());

        Tile tile = getQsTile();
        if (enhancerEnabled) {
            tile.setState(Tile.STATE_ACTIVE);
        } else {
            tile.setState(Tile.STATE_INACTIVE);
        }

        tile.updateTile();

        super.onStartListening();
    }

    @Override
    public void onClick() {
        Tile tile = getQsTile();
        if (mUtils.isEnabled(getApplicationContext())) {
            mUtils.setEnabled(getApplicationContext(), false);
            tile.setState(Tile.STATE_INACTIVE);
        } else {
            mUtils.setEnabled(getApplicationContext(), true);
            tile.setState(Tile.STATE_ACTIVE);
        }
        tile.updateTile();
        super.onClick();
    }
}
