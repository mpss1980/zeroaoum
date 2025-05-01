package br.com.coupledev.listadehabitos

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import br.com.coupledev.listadehabitos.core.datastore.SettingsDataStore

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        preferenceManager.preferenceDataStore = SettingsDataStore(requireContext())
        setPreferencesFromResource(R.xml.settings_preferences, rootKey)
    }
}