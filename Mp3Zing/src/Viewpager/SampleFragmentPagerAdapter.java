package Viewpager;

import mymusic.MymusicAlbumFragment;
import mymusic.MymusicBaihatFragment;
import mymusic.MymusicNghesyFragment;
import mymusic.MymusicPlaylistFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[] { "PLAYLIST", "BÀI HÁT", "ALBUM","NGHỆ SỸ" };

    public SampleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
    	switch (position) {
		case 0:				
			return new MymusicPlaylistFragment();
		case 1:
			return new MymusicBaihatFragment();
		case 2:
			return new MymusicAlbumFragment();
		case 3:
			return new MymusicNghesyFragment();
		}
		return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}