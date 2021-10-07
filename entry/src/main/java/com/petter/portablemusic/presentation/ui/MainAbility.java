package com.petter.portablemusic.presentation.ui;

import com.petter.portablemusic.presentation.ui.slice.MainAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.hiviewdfx.HiLogLabel;

public class MainAbility extends Ability {
    private static final String TAG = MainAbility.class.getSimpleName();

    private static final HiLogLabel LABEL_LOG = new HiLogLabel(3, 0xD000F00, TAG);

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
    }

}
