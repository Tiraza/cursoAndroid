package extractor.com.helloworld.webservice.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Locale;

import extractor.com.helloworld.webservice.fragments.FragmentCep;
import extractor.com.helloworld.webservice.fragments.FragmentLogradouro;
import extractor.com.helloworld.webservice.fragments.FragmentResposta;

public class SectionsPageAdapter extends FragmentPagerAdapter{

    FragmentCep cepFragment;
    FragmentLogradouro logradouroFragment;
    FragmentResposta respostaFragment;
    Context context;

    public SectionsPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                if(cepFragment == null){
                    cepFragment = new FragmentCep();
                }
                return cepFragment;

            case 1:
                if(logradouroFragment == null){
                    logradouroFragment = new FragmentLogradouro();
                }
                return logradouroFragment;

            case 2:
                if(respostaFragment == null){
                    respostaFragment = new FragmentResposta();
                }
                return respostaFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale locale = Locale.getDefault();
        switch (position){
            case 0:
                return "CEP".toUpperCase(locale);
            case 1:
                return  "Logradouro".toUpperCase(locale);
            case 2:
                return  "Resposta".toUpperCase(locale);
            default:
                return null;
        }
    }
}
