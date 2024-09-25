package com.example.myapplication

import android.R
import android.os.Bundle
import android.telecom.Call.Details
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.myapplication.databinding.FragmentWordPageBinding

class WordPage : Fragment() {

    private lateinit var binding: FragmentWordPageBinding
    private lateinit var wordsArrayList: ArrayList<Word_DB>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWordPageBinding.inflate(inflater, container, false)

        binding.backArrowWords.setOnClickListener {
            requireActivity().onBackPressed()
        }

        val subjectName = arguments?.getString("name")
        binding.subjectsListName.text = subjectName ?: "Subject Name"

        wordsArrayList = arrayListOf()

        val wordName = when (subjectName) {
            "Algebra a diskrétna matematika" -> arrayOf(
                Word_DB("Abelovská grupa", Difficulty.EASY, listOf("Абелева група"), listOf("Abelovská grupa je matematická štruktúra, ktorá je komutatívna, čo znamená, že poradie operácií nemá vplyv na výsledok."), "https://uk.wikipedia.org/wiki/%D0%90%D0%B1%D0%B5%D0%BB%D0%B5%D0%B2%D0%B0_%D0%B3%D1%80%D1%83%D0%BF%D0%B0"),
                Word_DB("Abstract algebra", Difficulty.EASY, listOf("Абстрактна алгебра"), listOf("Abstract algebra sa zaoberá štúdiom algebraických štruktúr, ako sú skupiny, okruhy a polia."), "https://uk.wikipedia.org/wiki/%D0%90%D0%B1%D1%81%D1%82%D1%80%D0%B0%D0%BA%D1%82%D0%BD%D0%B0_%D0%B0%D0%BB%D0%B3%D0%B5%D0%B1%D1%80%D0%B0"),
                Word_DB("Aditívnosť", Difficulty.EASY, listOf("Адитивність"), listOf("V matematike je aditívnosť vlastnosť, kde súčet viacerých členov neovplyvňuje výsledok."), "https://uk.wikipedia.org/wiki/%D0%90%D0%B4%D0%B8%D1%82%D0%B8%D0%B2%D0%BD%D1%96%D1%81%D1%82%D1%8C"),
                Word_DB("Adjungovaná matice", Difficulty.HARD, listOf("Союзна матриця"), listOf("Adjungovaná matica sa používa pri výpočte inverznej matice."), "https://uk.wikipedia.org/wiki/%D0%A1%D0%BE%D1%8E%D0%B7%D0%BD%D0%B0_%D0%BC%D0%B0%D1%82%D1%80%D0%B8%D1%86%D1%8F"),
                Word_DB("Algebrická rovnica", Difficulty.MEDIUM, listOf("Алгебричне рівняння"), listOf("Algebrická rovnica má premennú a môže mať jedno alebo viac riešení."), "https://uk.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%B5%D0%B1%D1%80%D0%B8%D1%87%D0%BD%D0%B5_%D1%80%D1%96%D0%B2%D0%BD%D1%8F%D0%BD%D0%BD%D1%8F"),
                Word_DB("Algebrická štruktúra", Difficulty.EASY, listOf("Алгебрична структура"), listOf("Algebrická štruktúra zahŕňa operácie a množiny, ktoré spĺňajú určité pravidlá."), "https://uk.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%B5%D0%B1%D1%80%D0%B8%D1%87%D0%BD%D0%B0_%D1%81%D1%82%D1%80%D1%83%D0%BA%D1%82%D1%83%D1%80%D0%B0"),
                Word_DB("Algebrický výraz", Difficulty.EASY, listOf("Алгебраїчний вираз"), listOf("Algebrický výraz môže byť zjednodušený pomocou pravidiel pre operácie."), "https://uk.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%B5%D0%B1%D1%80%D0%B0%D1%97%D1%87%D0%BD%D0%B8%D0%B9_%D0%B2%D0%B8%D1%80%D0%B0%D0%B7"),
                Word_DB("Antisymetrická relácia", Difficulty.MEDIUM, listOf("Антисиметричне відношення"), listOf("Antisymetrická relácia je taká, kde ak platí vzťah v jednom smere, neplatí v opačnom."), "https://uk.wikipedia.org/wiki/%D0%90%D0%BD%D1%82%D0%B8%D1%81%D0%B8%D0%BC%D0%B5%D1%82%D1%80%D0%B8%D1%87%D0%BD%D0%B5_%D0%B2%D1%96%D0%B4%D0%BD%D0%BE%D1%88%D0%B5%D0%BD%D0%BD%D1%8F"),
                Word_DB("Asociatívnosť", Difficulty.EASY, listOf("Асоціативність"), listOf("Asociatívnosť je vlastnosť operácie, kde poradie vykonávania neovplyvňuje výsledok."), "https://uk.wikipedia.org/wiki/%D0%90%D1%81%D0%BE%D1%86%D1%96%D0%B0%D1%82%D0%B8%D0%B2%D0%BD%D1%96%D1%81%D1%82%D1%8C"),
                Word_DB("Asociatívny grupoid", Difficulty.HARD, listOf("Напівгрупа"), listOf("Asociatívny grupoid je algebraická štruktúra s asociatívnou binárnou operáciou"), "https://uk.wikipedia.org/wiki/%D0%9D%D0%B0%D0%BF%D1%96%D0%B2%D0%B3%D1%80%D1%83%D0%BF%D0%B0"),
                Word_DB("Asymetrická relácia", Difficulty.MEDIUM, listOf("Асиметричне відношення"), listOf("Asymetrická relácia znamená, že ak platí vzťah medzi dvoma prvkami, neplatí opačný vzťah."), "https://uk.wikipedia.org/wiki/%D0%90%D1%81%D0%B8%D0%BC%D0%B5%D1%82%D1%80%D0%B8%D1%87%D0%BD%D0%B5_%D0%B2%D1%96%D0%B4%D0%BD%D0%BE%D1%88%D0%B5%D0%BD%D0%BD%D1%8F"),
                Word_DB("Axióma", Difficulty.EASY, listOf("Аксіома"), listOf("Axióma je základný matematický princíp, ktorý sa predpokladá bez dôkazu."), "https://uk.wikipedia.org/wiki/%D0%90%D0%BA%D1%81%D1%96%D0%BE%D0%BC%D0%B0"),

                Word_DB("Bijektívne zobrazenie", Difficulty.EASY, listOf("Бієкція"), listOf("Bijektívne zobrazenie je také, ktoré je súčasne injektívne aj surjektívne."), "https://uk.wikipedia.org/wiki/%D0%91%D1%96%D1%94%D0%BA%D1%86%D1%96%D1%8F"),
                Word_DB("Binárna operácia", Difficulty.EASY, listOf("Бінарна операція"), listOf("Binárna operácia je operácia, ktorá kombinuje dva prvky do jedného."), "https://uk.wikipedia.org/wiki/%D0%91%D1%96%D0%BD%D0%B0%D1%80%D0%BD%D0%B0_%D0%BE%D0%BF%D0%B5%D1%80%D0%B0%D1%86%D1%96%D1%8F"),
                Word_DB("Binárna relácia", Difficulty.MEDIUM, listOf("Бінарне відношення"), listOf("Binárna relácia určuje vzťah medzi dvoma prvkami množiny."), "https://uk.wikipedia.org/wiki/%D0%91%D1%96%D0%BD%D0%B0%D1%80%D0%BD%D0%B5_%D0%B2%D1%96%D0%B4%D0%BD%D0%BE%D1%88%D0%B5%D0%BD%D0%BD%D1%8F"),
                Word_DB("Binárny strom", Difficulty.MEDIUM, listOf("Двійкове дерево"), listOf("Binárny strom je dátová štruktúra, v ktorej každý uzol má najviac dvoch potomkov."), "https://uk.wikipedia.org/wiki/%D0%94%D0%B2%D1%96%D0%B9%D0%BA%D0%BE%D0%B2%D0%B5_%D0%B4%D0%B5%D1%80%D0%B5%D0%B2%D0%BE"),
                Word_DB("Binomická veta", Difficulty.HARD, listOf("Біном Ньютона"), listOf("Binomická veta je dôležitá matematická veta, vďaka ktorej môžeme n-tú mocninu dvoch sčítancov rozložiť na výraz súčtov n+1 sčítancov."), "https://uk.wikipedia.org/wiki/%D0%91%D1%96%D0%BD%D0%BE%D0%BC_%D0%9D%D1%8C%D1%8E%D1%82%D0%BE%D0%BD%D0%B0"),
                Word_DB("Binomický koeficient", Difficulty.MEDIUM, listOf("Біноміальний коефіцієнт"), listOf("Binomický koeficient sa používa pri rozvoji binomických výrazov."), "https://uk.wikipedia.org/wiki/%D0%91%D1%96%D0%BD%D0%BE%D0%BC%D1%96%D0%B0%D0%BB%D1%8C%D0%BD%D0%B8%D0%B9_%D0%BA%D0%BE%D0%B5%D1%84%D1%96%D1%86%D1%96%D1%94%D0%BD%D1%82"),
                Word_DB("Bipartitný graf", Difficulty.MEDIUM, listOf("Двочастковий граф"), listOf("Bipartitný graf je graf, ktorého vrcholy môžu byť rozdelené do dvoch nezávislých množín."), "https://uk.wikipedia.org/wiki/%D0%94%D0%B2%D0%BE%D1%87%D0%B0%D1%81%D1%82%D0%BA%D0%BE%D0%B2%D0%B8%D0%B9_%D0%B3%D1%80%D0%B0%D1%84"),
                Word_DB("Boolova algebra", Difficulty.MEDIUM, listOf("Алгебра логіки"), listOf("Boolova algebra je algebraická štruktúra používaná na vyjadrenie logických operácií."), "https://uk.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%B5%D0%B1%D1%80%D0%B0_%D0%BB%D0%BE%D0%B3%D1%96%D0%BA%D0%B8"),

                Word_DB("Cayley graf", Difficulty.EASY, listOf("Граф Келі"), listOf("Cayley graf je graf používaný na reprezentáciu štruktúr grúp."), "https://uk.wikipedia.org/wiki/%D0%93%D1%80%D0%B0%D1%84_%D0%9A%D0%B5%D0%BB%D1%96"),
                Word_DB("Celočíselný", Difficulty.EASY, listOf("Ціле число"), listOf("Celočíselný parameter znamená, že má len celé čísla."), ""),
                Word_DB("Cesta", Difficulty.MEDIUM, listOf("Шлях"), listOf("Cesta v grafe je sekvencia vrcholov, kde každý vrchol je spojený hranou."), ""),
                Word_DB("Chromatické číslo", Difficulty.EASY, listOf("Хроматичне число"), listOf("Chromatické číslo grafu je minimálny počet farieb potrebných na jeho ofarbenie."), "https://uk.wikipedia.org/wiki/%D0%A5%D1%80%D0%BE%D0%BC%D0%B0%D1%82%D0%B8%D1%87%D0%BD%D0%B5_%D1%87%D0%B8%D1%81%D0%BB%D0%BE"),
                Word_DB("Čiastočne usporiadaná množina", Difficulty.MEDIUM, listOf("Частково впорядкована множина"), listOf("Čiastočne usporiadaná množina je množina s usporiadaním, ktoré nie je nutne úplné."), "https://uk.wikipedia.org/wiki/%D0%A7%D0%B0%D1%81%D1%82%D0%BA%D0%BE%D0%B2%D0%BE_%D0%B2%D0%BF%D0%BE%D1%80%D1%8F%D0%B4%D0%BA%D0%BE%D0%B2%D0%B0%D0%BD%D0%B0_%D0%BC%D0%BD%D0%BE%D0%B6%D0%B8%D0%BD%D0%B0"),
                Word_DB("Cramérova veta", Difficulty.EASY, listOf("Теорема Крамера — Вольда"), listOf("Cramérova veta sa používa pri riešení lineárnych sústav rovníc."), "https://uk.wikipedia.org/wiki/%D0%A2%D0%B5%D0%BE%D1%80%D0%B5%D0%BC%D0%B0_%D0%9A%D1%80%D0%B0%D0%BC%D0%B5%D1%80%D0%B0_%E2%80%94_%D0%92%D0%BE%D0%BB%D1%8C%D0%B4%D0%B0"),
                Word_DB("Cyklus", Difficulty.EASY, listOf("Цикл"), listOf("Cyklus v grafe je uzavretá cesta, kde sa vraciate do východiskového bodu."), ""),

                Word_DB("Deliteľnosť", Difficulty.EASY, listOf("Подільність"), listOf("Deliteľnosť je vlastnosť, keď jedno číslo môže byť deliteľné druhým bez zvyšku."), ""),
                Word_DB("Determinant", Difficulty.HARD, listOf("Визначник"), listOf("Determinant matice je skalárna hodnota, ktorá poskytuje informácie o vlastnostiach matice."), "https://uk.wikipedia.org/wiki/%D0%92%D0%B8%D0%B7%D0%BD%D0%B0%D1%87%D0%BD%D0%B8%D0%BA"),
                Word_DB("Dihedrálna grupa", Difficulty.MEDIUM, listOf("Діедрична група"), listOf("Dihedrálna grupa reprezentuje symetrie pravidelného mnohouholníka."), "https://uk.wikipedia.org/wiki/%D0%94%D1%96%D0%B5%D0%B4%D1%80%D0%B8%D1%87%D0%BD%D0%B0_%D0%B3%D1%80%D1%83%D0%BF%D0%B0"),
                Word_DB("Diofantická rovnice", Difficulty.MEDIUM, listOf("Діофантові рівняння"), listOf("Diofantická rovnica je algebraická rovnica s celočíselnými koeficientmi a riešeniami."), "https://uk.wikipedia.org/wiki/%D0%94%D1%96%D0%BE%D1%84%D0%B0%D0%BD%D1%82%D0%BE%D0%B2%D1%96_%D1%80%D1%96%D0%B2%D0%BD%D1%8F%D0%BD%D0%BD%D1%8F"),
                Word_DB("Disjunkcia", Difficulty.EASY, listOf("Диз'юнкція"), listOf("Disjunkcia je logická operácia, ktorá je pravdivá, ak aspoň jeden z operandov je pravdivý."), "https://uk.wikipedia.org/wiki/%D0%94%D0%B8%D0%B7%27%D1%8E%D0%BD%D0%BA%D1%86%D1%96%D1%8F_(%D0%BB%D0%BE%D0%B3%D1%96%D0%BA%D0%B0)"),
                Word_DB("Disjunktívna normálna forma", Difficulty.EASY, listOf("Диз'юнктивна нормальна форма"), listOf("Disjunktívna normálna forma je štandardná forma logického výrazu."), "https://uk.wikipedia.org/wiki/%D0%94%D0%B8%D0%B7%27%D1%8E%D0%BD%D0%BA%D1%82%D0%B8%D0%B2%D0%BD%D0%B0_%D0%BD%D0%BE%D1%80%D0%BC%D0%B0%D0%BB%D1%8C%D0%BD%D0%B0_%D1%84%D0%BE%D1%80%D0%BC%D0%B0"),
                Word_DB("Disjunktné množiny", Difficulty.HARD, listOf("Неперетинні множини"), listOf("Disjunktné množiny sú také, ktoré nemajú žiadny spoločný prvok."), "https://uk.wikipedia.org/wiki/%D0%9D%D0%B5%D0%BF%D0%B5%D1%80%D0%B5%D1%82%D0%B8%D0%BD%D0%BD%D1%96_%D0%BC%D0%BD%D0%BE%D0%B6%D0%B8%D0%BD%D0%B8"),
                Word_DB("Diskrétna matematika", Difficulty.EASY, listOf("Дискретна математика"), listOf("Diskrétna matematika sa zaoberá štúdiom štruktúr, ktoré nie sú kontinuálne."), "https://uk.wikipedia.org/wiki/%D0%94%D0%B8%D1%81%D0%BA%D1%80%D0%B5%D1%82%D0%BD%D0%B0_%D0%BC%D0%B0%D1%82%D0%B5%D0%BC%D0%B0%D1%82%D0%B8%D0%BA%D0%B0"),
                Word_DB("Dôkaz", Difficulty.EASY, listOf("Доказ"), listOf("Dôkaz je formálna postupnosť krokov, ktorá preukazuje pravdivosť tvrdenia."), ""),
                Word_DB("Dolné ohraničenie", Difficulty.MEDIUM, listOf("Нижнє обмеження"), listOf("Dolné ohraničenie je najnižšia hodnota, ktorú môže mať množina čísel."), ""),
                Word_DB("Doplnok", Difficulty.MEDIUM, listOf("Доповнення"), listOf("Doplnok množiny obsahuje všetky prvky, ktoré nie sú v danej množine."), ""),
                Word_DB("Doplnok množiny", Difficulty.MEDIUM, listOf("Доповнення множин"), listOf("Doplnok množiny, alebo komplement množiny, je množina všetkých prvkov, ktoré patria do základnej množiny, ale nepatria do danej podmnožiny."), "https://uk.wikipedia.org/wiki/%D0%94%D0%BE%D0%BF%D0%BE%D0%B2%D0%BD%D0%B5%D0%BD%D0%BD%D1%8F_%D0%BC%D0%BD%D0%BE%D0%B6%D0%B8%D0%BD"),
                Word_DB("Dvadsaťsten", Difficulty.MEDIUM, listOf("Ікосаедр", "двадцятигранник"), listOf("Dvadsaťsten je pravidelné teleso s 20 stenami."), "https://uk.wikipedia.org/wiki/%D0%86%D0%BA%D0%BE%D1%81%D0%B0%D0%B5%D0%B4%D1%80"),
                Word_DB("Dvanásťsten", Difficulty.MEDIUM, listOf("Правильний додекаедр", "дванадцятигранник"), listOf("Dvanásťsten je pravidelné teleso s 12 stenami."), "https://uk.wikipedia.org/wiki/%D0%9F%D1%80%D0%B0%D0%B2%D0%B8%D0%BB%D1%8C%D0%BD%D0%B8%D0%B9_%D0%B4%D0%BE%D0%B4%D0%B5%D0%BA%D0%B0%D0%B5%D0%B4%D1%80"),
                Word_DB("Dvojnásobok", Difficulty.HARD, listOf("Подвійна кількість"), listOf("Dvojnásobok čísla je jeho súčin s číslom dva."), ""),

                Word_DB("Elementárna algebra", Difficulty.EASY, listOf("Елементарна алгебра"), listOf("Elementárna algebra sa zaoberá základnými operáciami s číslami a premennými."), "https://uk.wikipedia.org/wiki/%D0%95%D0%BB%D0%B5%D0%BC%D0%B5%D0%BD%D1%82%D0%B0%D1%80%D0%BD%D0%B0_%D0%B0%D0%BB%D0%B3%D0%B5%D0%B1%D1%80%D0%B0"),
                Word_DB("Enumerácia", Difficulty.HARD, listOf("Перелічення"), listOf("Enumerácia je proces vypísania alebo spočítania všetkých prvkov množiny."), ""),
                Word_DB("Eulerovský ťah", Difficulty.MEDIUM, listOf("Ейлерів ланцюг"), listOf("Eulerovský ťah v grafe prechádza každou hranou presne raz."), "https://uk.wikipedia.org/wiki/%D0%95%D0%B9%D0%BB%D0%B5%D1%80%D1%96%D0%B2_%D0%BB%D0%B0%D0%BD%D1%86%D1%8E%D0%B3"),
                Word_DB("Existovať", Difficulty.MEDIUM, listOf("Існувати"), listOf("Existovať znamená byť prítomný alebo mať nejakú formu."), ""),

                Word_DB("Faktor grafu", Difficulty.EASY, listOf("Факторизація графа"), listOf("Faktor grafu je podgraf, ktorý obsahuje podmnožinu hrán pôvodného grafu."), "https://uk.wikipedia.org/wiki/%D0%A4%D0%B0%D0%BA%D1%82%D0%BE%D1%80%D0%B8%D0%B7%D0%B0%D1%86%D1%96%D1%8F_%D0%B3%D1%80%D0%B0%D1%84%D0%B0"),
                Word_DB("Farbenie grafov", Difficulty.EASY, listOf("Розфарбовування графів"), listOf("Farbenie grafov je spôsob priradenia farieb vrcholom alebo hranám grafu."), ""),
                Word_DB("Fibonacciho postupnosť", Difficulty.EASY, listOf("Послідовність Фібоначчі"), listOf("Fibonacciho postupnosť je sekvencia, kde každý člen je súčtom dvoch predchádzajúcich."), "https://uk.wikipedia.org/wiki/%D0%9F%D0%BE%D1%81%D0%BB%D1%96%D0%B4%D0%BE%D0%B2%D0%BD%D1%96%D1%81%D1%82%D1%8C_%D0%A4%D1%96%D0%B1%D0%BE%D0%BD%D0%B0%D1%87%D1%87%D1%96"),
                Word_DB("Fraktál", Difficulty.EASY, listOf("Фрактал"), listOf("Fraktál je geometrický objekt, ktorý je sebapodobný v rôznych mierkach."), "https://uk.wikipedia.org/wiki/%D0%A4%D1%80%D0%B0%D0%BA%D1%82%D0%B0%D0%BB"),

                Word_DB("Gaussova eliminácia", Difficulty.MEDIUM, listOf("Метод Гаусса"), listOf("Gaussova eliminácia je metóda riešenia sústav lineárnych rovníc."), "https://uk.wikipedia.org/wiki/%D0%9C%D0%B5%D1%82%D0%BE%D0%B4_%D0%93%D0%B0%D1%83%D1%81%D1%81%D0%B0"),
                Word_DB("Graciózne ohodnotenie", Difficulty.MEDIUM, listOf("Граціозна розмітка"), listOf("Graciózne ohodnotenie je špeciálny spôsob ohodnotenia vrcholov a hrán grafu."), "https://uk.wikipedia.org/wiki/%D0%93%D1%80%D0%B0%D1%86%D1%96%D0%BE%D0%B7%D0%BD%D0%B0_%D1%80%D0%BE%D0%B7%D0%BC%D1%96%D1%82%D0%BA%D0%B0"),
                Word_DB("Graf", Difficulty.EASY, listOf("Граф"), listOf("Graf je matematický objekt pozostávajúci z vrcholov a hrán."), "https://uk.wikipedia.org/wiki/%D0%93%D1%80%D0%B0%D1%84_(%D0%BC%D0%B0%D1%82%D0%B5%D0%BC%D0%B0%D1%82%D0%B8%D0%BA%D0%B0)"),
                Word_DB("Grupoid", Difficulty.EASY, listOf("Магма", "групоїд"), listOf("Grupoid je algebraická štruktúra s binárnou operáciou, ale nemusí byť asociatívna."), "https://uk.wikipedia.org/wiki/%D0%9C%D0%B0%D0%B3%D0%BC%D0%B0_(%D0%B0%D0%BB%D0%B3%D0%B5%D0%B1%D1%80%D0%B0)"),
                Word_DB("Guľa", Difficulty.MEDIUM, listOf("Шар"), listOf("Guľa je geometrické teleso, kde všetky body na povrchu sú rovnako vzdialené od stredu."), ""),

                Word_DB("Hamiltonovský graf", Difficulty.EASY, listOf("Гамільтонів граф"), listOf("Hamiltonovský graf obsahuje cestu, ktorá prechádza každým vrcholom presne raz."), "https://uk.wikipedia.org/wiki/%D0%93%D0%B0%D0%BC%D1%96%D0%BB%D1%8C%D1%82%D0%BE%D0%BD%D1%96%D0%B2_%D0%B3%D1%80%D0%B0%D1%84"),
                Word_DB("Hasseho diagram", Difficulty.EASY, listOf("Діаграма Гассе"), listOf("Hasseho diagram sa používa na znázornenie čiastočne usporiadaných množín."), "https://uk.wikipedia.org/wiki/%D0%94%D1%96%D0%B0%D0%B3%D1%80%D0%B0%D0%BC%D0%B0_%D0%93%D0%B0%D1%81%D1%81%D0%B5"),
                Word_DB("Heuristika", Difficulty.MEDIUM, listOf("Евристика"), listOf("Heuristika je stratégia alebo prístup na riešenie problémov na základe skúseností."), "https://uk.wikipedia.org/wiki/%D0%95%D0%B2%D1%80%D0%B8%D1%81%D1%82%D0%B8%D0%BA%D0%B0"),
                Word_DB("Hodnota", Difficulty.MEDIUM, listOf("Вартість", "значення"), listOf("Hodnota vyjadruje veľkosť alebo kvantitu konkrétneho čísla alebo výrazu."), ""),
                Word_DB("Homogénna sústava", Difficulty.EASY, listOf("Гомогенна система"), listOf("Homogénna sústava rovníc má všetky pravé strany rovné nule."), "https://uk.wikipedia.org/wiki/%D0%93%D0%BE%D0%BC%D0%BE%D0%B3%D0%B5%D0%BD%D0%BD%D0%B0_%D1%81%D0%B8%D1%81%D1%82%D0%B5%D0%BC%D0%B0"),
                Word_DB("Homomorfizmus", Difficulty.EASY, listOf("Гомоморфізм"), listOf("Homomorfizmus je zobrazenie, ktoré zachováva algebraickú štruktúru medzi dvoma množinami."), "https://uk.wikipedia.org/wiki/%D0%93%D0%BE%D0%BC%D0%BE%D0%BC%D0%BE%D1%80%D1%84%D1%96%D0%B7%D0%BC"),
                Word_DB("Horné ohraničenie", Difficulty.MEDIUM, listOf("Верхнє обмеження"), listOf("Horné ohraničenie je najvyššia možná hodnota prvku v danej množine."), ""),
                Word_DB("Hrana", Difficulty.EASY, listOf("Грань"), listOf("Hrana v grafe spája dva vrcholy."), ""),
                Word_DB("Hranaté zátvorky", Difficulty.HARD, listOf("Квадратні дужки"), listOf("Hranaté zátvorky sa používajú na označenie určitých výrazov v matematike alebo programovaní."), ""),
                Word_DB("Hranatý", Difficulty.HARD, listOf("Чотирикутний", "кутастий"), listOf("Hranatý tvar znamená, že má rovné hrany a pravé uhly."), ""),
                Word_DB("Hranové ofarbenie grafu", Difficulty.MEDIUM, listOf("Розфарбовування ребер"), listOf("Hranové ofarbenie grafu priraďuje farby hranám tak, aby žiadne dve susedné hrany nemali rovnakú farbu."), "https://uk.wikipedia.org/wiki/%D0%A0%D0%BE%D0%B7%D1%84%D0%B0%D1%80%D0%B1%D0%BE%D0%B2%D1%83%D0%B2%D0%B0%D0%BD%D0%BD%D1%8F_%D1%80%D0%B5%D0%B1%D0%B5%D1%80"),
                Word_DB("Hviezda", Difficulty.MEDIUM, listOf("Зірка"), listOf("Hviezda v grafe je strom s jedným centrálnym vrcholom a ostatnými vrcholmi spojenými s týmto centrom."), ""),

                Word_DB("Ideál", Difficulty.EASY, listOf("Ідеал"), listOf("Ideál je podmnožina okruhu, ktorá je uzavretá pod súčtom a násobením prvkami okruhu."), "https://uk.wikipedia.org/wiki/%D0%86%D0%B4%D0%B5%D0%B0%D0%BB_(%D0%B0%D0%BB%D0%B3%D0%B5%D0%B1%D1%80%D0%B0)"),
                Word_DB("Implikácia", Difficulty.MEDIUM, listOf("Логічна імплікація"), listOf("Implikácia je logická operácia, ktorá hovorí, že ak platí prvý výraz, musí platiť aj druhý."), "https://uk.wikipedia.org/wiki/%D0%9B%D0%BE%D0%B3%D1%96%D1%87%D0%BD%D0%B0_%D1%96%D0%BC%D0%BF%D0%BB%D1%96%D0%BA%D0%B0%D1%86%D1%96%D1%8F"),
                Word_DB("Indukovaný podgraf", Difficulty.EASY, listOf("Індукований підграф"), listOf("Indukovaný podgraf je podgraf, ktorý obsahuje všetky hrany medzi vrcholmi pôvodného grafu."), ""),
                Word_DB("Injekcia", Difficulty.EASY, listOf("Ін'єкція"), listOf("Injekcia je zobrazenie, ktoré každému prvku priradí unikátny obraz."), "https://uk.wikipedia.org/wiki/%D0%86%D0%BD%27%D1%94%D0%BA%D1%86%D1%96%D1%8F_(%D0%BC%D0%B0%D1%82%D0%B5%D0%BC%D0%B0%D1%82%D0%B8%D0%BA%D0%B0)"),
                Word_DB("Inverzná matica", Difficulty.MEDIUM, listOf("Обернена матриця"), listOf("Inverzná matica je matica, ktorá vynásobená s pôvodnou maticou dáva jednotkovú maticu."), "https://uk.wikipedia.org/wiki/%D0%9E%D0%B1%D0%B5%D1%80%D0%BD%D0%B5%D0%BD%D0%B0_%D0%BC%D0%B0%D1%82%D1%80%D0%B8%D1%86%D1%8F"),
                Word_DB("Inverzný prvok", Difficulty.MEDIUM, listOf("Обернений елемент"), listOf("Inverzný prvok je prvok, ktorý pri operácii s iným prvkom dáva neutrálny prvok."), "https://uk.wikipedia.org/wiki/%D0%9E%D0%B1%D0%B5%D1%80%D0%BD%D0%B5%D0%BD%D0%B8%D0%B9_%D0%B5%D0%BB%D0%B5%D0%BC%D0%B5%D0%BD%D1%82"),
                Word_DB("Izomorfizmus grafov", Difficulty.EASY, listOf("Ізоморфізм графів"), listOf("Izomorfizmus grafov znamená, že dva grafy sú identické po zobrazení ich vrcholov a hrán."), "https://uk.wikipedia.org/wiki/%D0%86%D0%B7%D0%BE%D0%BC%D0%BE%D1%80%D1%84%D1%96%D0%B7%D0%BC_%D0%B3%D1%80%D0%B0%D1%84%D1%96%D0%B2"),
                Word_DB("Izomorfizmus grúp", Difficulty.EASY, listOf("Ізоморфізм груп"), listOf("Izomorfizmus grúp je bijektívne zobrazenie medzi dvoma skupinami, ktoré zachováva ich štruktúru."), "https://uk.wikipedia.org/wiki/%D0%86%D0%B7%D0%BE%D0%BC%D0%BE%D1%80%D1%84%D1%96%D0%B7%D0%BC_%D0%B3%D1%80%D1%83%D0%BF"),

                Word_DB("Jediné riešenie", Difficulty.EASY, listOf("Єдине рішення"), listOf("Jediné riešenie sústavy rovníc nastáva, keď existuje presne jedno riešenie."), ""),
                Word_DB("Jednoznačný", Difficulty.EASY, listOf("Однозначний"), listOf("Jednoznačný výstup znamená, že existuje len jedna správna odpoveď alebo výsledok."), ""),

                Word_DB("Karteziánsky súčin", Difficulty.HARD, listOf("Декартів добуток"), listOf("Karteziánsky súčin je množina všetkých usporiadaných dvojíc prvkov z dvoch množín."), "https://uk.wikipedia.org/wiki/%D0%94%D0%B5%D0%BA%D0%B0%D1%80%D1%82%D1%96%D0%B2_%D0%B4%D0%BE%D0%B1%D1%83%D1%82%D0%BE%D0%BA"),
                Word_DB("Kocka", Difficulty.MEDIUM, listOf("Куб"), listOf("Kocka je pravidelný mnohosten s rovnakými hranami a plochami."), ""),
                Word_DB("Kombinácia", Difficulty.EASY, listOf("Комбінація"), listOf("Kombinácia je výber prvkov z množiny bez ohľadu na ich poradie."), "https://uk.wikipedia.org/wiki/%D0%9A%D0%BE%D0%BC%D0%B1%D1%96%D0%BD%D0%B0%D1%86%D1%96%D1%8F_(%D0%BA%D0%BE%D0%BC%D0%B1%D1%96%D0%BD%D0%B0%D1%82%D0%BE%D1%80%D0%B8%D0%BA%D0%B0)"),
                Word_DB("Kombinačné číslo", Difficulty.HARD, listOf("Біноміальний коефіцієнт"), listOf("Kombinačné číslo udáva počet spôsobov, akými môžeme vybrať prvky z množiny."), "https://uk.wikipedia.org/wiki/%D0%91%D1%96%D0%BD%D0%BE%D0%BC%D1%96%D0%B0%D0%BB%D1%8C%D0%BD%D0%B8%D0%B9_%D0%BA%D0%BE%D0%B5%D1%84%D1%96%D1%86%D1%96%D1%94%D0%BD%D1%82"),
                Word_DB("Kombinatorika", Difficulty.EASY, listOf("Комбінаторика"), listOf("Kombinatorika je oblasť matematiky, ktorá sa zaoberá počítaním, výberom a usporiadaním prvkov."), "https://uk.wikipedia.org/wiki/%D0%9A%D0%BE%D0%BC%D0%B1%D1%96%D0%BD%D0%B0%D1%82%D0%BE%D1%80%D0%B8%D0%BA%D0%B0"),
                Word_DB("Komplement grafu", Difficulty.HARD, listOf("Доповнення графа"), listOf("Komplement grafu je graf, ktorý obsahuje všetky hrany, ktoré chýbajú v pôvodnom grafe."), "https://uk.wikipedia.org/wiki/%D0%94%D0%BE%D0%BF%D0%BE%D0%B2%D0%BD%D0%B5%D0%BD%D0%BD%D1%8F_%D0%B3%D1%80%D0%B0%D1%84%D0%B0"),
                Word_DB("Kompletný graf", Difficulty.MEDIUM, listOf("Повний граф"), listOf("Kompletný graf má hranu medzi každými dvoma vrcholmi."), "https://uk.wikipedia.org/wiki/%D0%9F%D0%BE%D0%B2%D0%BD%D0%B8%D0%B9_%D0%B3%D1%80%D0%B0%D1%84"),
                Word_DB("Komutatívnosť", Difficulty.EASY, listOf("Комутативність"), listOf("Komutatívnosť znamená, že výsledok operácie nezávisí na poradí operandov."), "https://uk.wikipedia.org/wiki/%D0%9A%D0%BE%D0%BC%D1%83%D1%82%D0%B0%D1%82%D0%B8%D0%B2%D0%BD%D1%96%D1%81%D1%82%D1%8C"),
                Word_DB("Konečný automat", Difficulty.MEDIUM, listOf("Скінченний автомат"), listOf("Konečný automat je teoretický model, ktorý predstavuje systém s obmedzeným počtom stavov."), "https://uk.wikipedia.org/wiki/%D0%A1%D0%BA%D1%96%D0%BD%D1%87%D0%B5%D0%BD%D0%BD%D0%B8%D0%B9_%D0%B0%D0%B2%D1%82%D0%BE%D0%BC%D0%B0%D1%82"),
                Word_DB("Konjunkcia", Difficulty.EASY, listOf("Кон'юнкція"), listOf("Konjunkcia je logická operácia, ktorá je pravdivá, len ak sú oba výrazy pravdivé."), "https://uk.wikipedia.org/wiki/%D0%9A%D0%BE%D0%BD%27%D1%8E%D0%BD%D0%BA%D1%86%D1%96%D1%8F"),
                Word_DB("Konjunktívna normálna forma", Difficulty.EASY, listOf("Кон'юнктивна нормальна форма"), listOf("Konjunktívna normálna forma je štandardná forma logických výrokov v tvare konjunkcií disjunkcií."), "https://uk.wikipedia.org/wiki/%D0%9A%D0%BE%D0%BD%27%D1%8E%D0%BD%D0%BA%D1%82%D0%B8%D0%B2%D0%BD%D0%B0_%D0%BD%D0%BE%D1%80%D0%BC%D0%B0%D0%BB%D1%8C%D0%BD%D0%B0_%D1%84%D0%BE%D1%80%D0%BC%D0%B0"),
                Word_DB("Kontradikcia", Difficulty.HARD, listOf("Протиріччя"), listOf("Kontradikcia je logická situácia, kde výrok odporuje sám sebe."), ""),
                Word_DB("Koreň", Difficulty.EASY, listOf("Корінь"), listOf("Koreň polynómu je číslo, pre ktoré polynóm nadobúda hodnotu nula."), ""),
                Word_DB("Kostra grafu", Difficulty.MEDIUM, listOf("Кістякове дерево"), listOf("Kostra grafu je podgraf, ktorý obsahuje všetky vrcholy pôvodného grafu a minimálny počet hrán."), "https://uk.wikipedia.org/wiki/%D0%9A%D1%96%D1%81%D1%82%D1%8F%D0%BA%D0%BE%D0%B2%D0%B5_%D0%B4%D0%B5%D1%80%D0%B5%D0%B2%D0%BE"),
                Word_DB("Krivka", Difficulty.EASY, listOf("Крива"), listOf("Krivka je geometrický útvar tvorený spojitou cestou bodov."), ""),
                Word_DB("Kruskalov algoritmus", Difficulty.EASY, listOf("Алгоритм Крускала"), listOf("Kruskalov algoritmus sa používa na nájdenie minimálnej kostry grafu."), "https://uk.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D0%9A%D1%80%D1%83%D1%81%D0%BA%D0%B0%D0%BB%D0%B0"),
                Word_DB("Kružidlo", Difficulty.HARD, listOf("Циркуль"), listOf("Kružidlo je nástroj na kreslenie kružníc alebo oblúkov."), ""),
                Word_DB("Kružnica", Difficulty.MEDIUM, listOf("Коло"), listOf("Kružnica je množina bodov v rovine, ktoré sú rovnako vzdialené od jedného bodu."), "https://uk.wikipedia.org/wiki/%D0%9A%D0%BE%D0%BB%D0%BE"),
                Word_DB("Kvadratická rovnica", Difficulty.EASY, listOf("Квадратне рівняння"), listOf("Kvadratická rovnica je rovnica druhého stupňa v tvare: ax² + bx + c = 0"), "https://uk.wikipedia.org/wiki/%D0%9A%D0%B2%D0%B0%D0%B4%D1%80%D0%B0%D1%82%D0%BD%D0%B5_%D1%80%D1%96%D0%B2%D0%BD%D1%8F%D0%BD%D0%BD%D1%8F"),
                Word_DB("Kvadratúra kruhu", Difficulty.EASY, listOf("Квадратура круга"), listOf("Kvadratúra kruhu je klasický problém geometrie, ktorý sa snaží zostrojiť štvorec s rovnakou plochou ako daná kružnica."), "https://uk.wikipedia.org/wiki/%D0%9A%D0%B2%D0%B0%D0%B4%D1%80%D0%B0%D1%82%D1%83%D1%80%D0%B0_%D0%BA%D1%80%D1%83%D0%B3%D0%B0"),

                Word_DB("Lineárna algebra", Difficulty.EASY, listOf("Лінійна алгебра"), listOf("Lineárna algebra sa zaoberá vektorovými priestormi a lineárnymi transformáciami."), "https://uk.wikipedia.org/wiki/%D0%9B%D1%96%D0%BD%D1%96%D0%B9%D0%BD%D0%B0_%D0%B0%D0%BB%D0%B3%D0%B5%D0%B1%D1%80%D0%B0"),
                Word_DB("Lineárna rekurencia", Difficulty.MEDIUM, listOf("Лінійна рекурсія"), listOf("Lineárna rekurencia opisuje postupnosť, kde každý člen závisí lineárne od predchádzajúcich členov."), "https://uk.wikipedia.org/wiki/%D0%A0%D0%B5%D0%BA%D1%83%D1%80%D1%81%D1%96%D1%8F"),
                Word_DB("Lineárne usporiadaná množina", Difficulty.MEDIUM, listOf("Лінійно впорядкована множина"), listOf("Lineárne usporiadaná množina má také usporiadanie, že každý pár prvkov je porovnateľný."), "https://uk.wikipedia.org/wiki/%D0%9B%D1%96%D0%BD%D1%96%D0%B9%D0%BD%D0%BE_%D0%B2%D0%BF%D0%BE%D1%80%D1%8F%D0%B4%D0%BA%D0%BE%D0%B2%D0%B0%D0%BD%D0%B0_%D0%BC%D0%BD%D0%BE%D0%B6%D0%B8%D0%BD%D0%B0"),
                Word_DB("Lineárne zobrazenie", Difficulty.MEDIUM, listOf("Лінійне відображення"), listOf("Lineárne zobrazenie je funkcia medzi dvoma vektorovými priestormi, ktorá zachováva operácie sčítania a násobenia skalárom."), "https://uk.wikipedia.org/wiki/%D0%9B%D1%96%D0%BD%D1%96%D0%B9%D0%BD%D0%B5_%D0%B2%D1%96%D0%B4%D0%BE%D0%B1%D1%80%D0%B0%D0%B6%D0%B5%D0%BD%D0%BD%D1%8F"),
                Word_DB("List", Difficulty.EASY, listOf("Лист"), listOf("List v binárnom strome je vrchol, ktorý nemá žiadnych potomkov."), ""),
                Word_DB("Logaritmus", Difficulty.EASY, listOf("Логарифм"), listOf("Logaritmus je inverzná operácia k umocňovaniu, ktorá odpovedá na otázku, na akú mocninu musíme umocniť základ, aby sme získali dané číslo."), "https://uk.wikipedia.org/wiki/%D0%9B%D0%BE%D0%B3%D0%B0%D1%80%D0%B8%D1%84%D0%BC"),
                Word_DB("Lomené zátvorky", Difficulty.HARD, listOf("Кутові дужки"), listOf("Lomené zátvorky sa používajú na špeciálne matematické výrazy alebo štruktúry, napríklad na zobrazenie hodnôt z intervalu."), ""),
                Word_DB("Ľubovoľný", Difficulty.EASY, listOf("Будь-який"), listOf("Ľubovoľný prvok množiny môže byť vybraný bez obmedzení alebo preferencií."), ""),

                Word_DB("Matematická indukcia", Difficulty.EASY, listOf("Математична індукція"), listOf("Matematická indukcia je metóda dôkazu, kde sa najprv ukáže platnosť pre základný prípad a potom sa preukáže platnosť pre nasledujúci krok."), "https://uk.wikipedia.org/wiki/%D0%9C%D0%B0%D1%82%D0%B5%D0%BC%D0%B0%D1%82%D0%B8%D1%87%D0%BD%D0%B0_%D1%96%D0%BD%D0%B4%D1%83%D0%BA%D1%86%D1%96%D1%8F"),
                Word_DB("Matica", Difficulty.MEDIUM, listOf("Матриця"), listOf("Matica je obdĺžniková tabuľka čísel alebo výrazov usporiadaných do riadkov a stĺpcov."), "https://uk.wikipedia.org/wiki/%D0%9C%D0%B0%D1%82%D1%80%D0%B8%D1%86%D1%8F_(%D0%BC%D0%B0%D1%82%D0%B5%D0%BC%D0%B0%D1%82%D0%B8%D0%BA%D0%B0)"),
                Word_DB("Matica susednosti", Difficulty.EASY, listOf("Матриця суміжності"), listOf("Matica susednosti reprezentuje graf tým, že udáva, ktoré vrcholy sú spojené hranami."), "https://uk.wikipedia.org/wiki/%D0%9C%D0%B0%D1%82%D1%80%D0%B8%D1%86%D1%8F_%D1%81%D1%83%D0%BC%D1%96%D0%B6%D0%BD%D0%BE%D1%81%D1%82%D1%96"),
                Word_DB("Minimálna kostra grafu", Difficulty.MEDIUM, listOf("Мінімальне кістякове дерево"), listOf("Minimálna kostra grafu je podgraf, ktorý obsahuje všetky vrcholy pôvodného grafu a minimálny súčet dĺžok hrán."), "https://uk.wikipedia.org/wiki/%D0%9C%D1%96%D0%BD%D1%96%D0%BC%D0%B0%D0%BB%D1%8C%D0%BD%D0%B5_%D0%BA%D1%96%D1%81%D1%82%D1%8F%D0%BA%D0%BE%D0%B2%D0%B5_%D0%B4%D0%B5%D1%80%D0%B5%D0%B2%D0%BE"),
                Word_DB("Mnohočlen", Difficulty.EASY, listOf("Многочлен"), listOf("Mnohočlen je algebraický výraz, ktorý je súčtom monomov."), "https://uk.wikipedia.org/wiki/%D0%9C%D0%BD%D0%BE%D0%B3%D0%BE%D1%87%D0%BB%D0%B5%D0%BD"),
                Word_DB("Mnohouholník", Difficulty.EASY, listOf("Многокутник"), listOf("Mnohouholník je rovinný geometrický útvar ohraničený priamkami, ktorý má viacero strán."), "https://uk.wikipedia.org/wiki/%D0%9C%D0%BD%D0%BE%D0%B3%D0%BE%D0%BA%D1%83%D1%82%D0%BD%D0%B8%D0%BA"),
                Word_DB("Množina", Difficulty.EASY, listOf("Множина"), listOf("Množina je súbor prvkov, ktoré spĺňajú určité kritériá alebo vlastnosti"), "https://uk.wikipedia.org/wiki/%D0%9C%D0%BD%D0%BE%D0%B6%D0%B8%D0%BD%D0%B0"),
                Word_DB("Množina bodov", Difficulty.EASY, listOf("Множина точок"), listOf("Množina bodov môže predstavovať napríklad geometrické body, ktoré spĺňajú určitú vlastnosť v priestore."), ""),
                Word_DB("Modulárna aritmetika", Difficulty.EASY, listOf("Модульна арифметика"), listOf("Modulárna aritmetika sa zaoberá číslami v rámci určitého modulu, pričom sa berie do úvahy zvyšok po delení."), "https://uk.wikipedia.org/wiki/%D0%9C%D0%BE%D0%B4%D1%83%D0%BB%D1%8C%D0%BD%D0%B0_%D0%B0%D1%80%D0%B8%D1%84%D0%BC%D0%B5%D1%82%D0%B8%D0%BA%D0%B0"),
                Word_DB("Module", Difficulty.EASY, listOf("Модуль"), listOf("Module je algebraická štruktúra, ktorá rozširuje pojem vektorového priestoru."), "https://uk.wikipedia.org/wiki/%D0%9C%D0%BE%D0%B4%D1%83%D0%BB%D1%8C_%D0%BD%D0%B0%D0%B4_%D0%BA%D1%96%D0%BB%D1%8C%D1%86%D0%B5%D0%BC"),
                Word_DB("Monoid", Difficulty.EASY, listOf("Моноїд"), listOf("Monoid je algebraická štruktúra s jednou operáciou, ktorá je asociatívna a má neutrálny prvok."), "https://uk.wikipedia.org/wiki/%D0%9C%D0%BE%D0%BD%D0%BE%D1%97%D0%B4"),
                Word_DB("Mriežka", Difficulty.HARD, listOf("Сітка"), listOf("Mriežka je štruktúra, ktorá pozostáva z vrcholov a hrán usporiadaných do pravidelného vzoru."), ""),

                Word_DB("Náčrt", Difficulty.MEDIUM, listOf("Начерк", "ескіз"), listOf("Náčrt v matematike môže byť vizuálny plán alebo reprezentácia konceptu, ako je graf alebo diagram."), ""),
                Word_DB("Najmenší", Difficulty.EASY, listOf("Найменший"), listOf("Najmenší prvok v čiastočne usporiadanej množine je prvok, ktorý je menší alebo rovný všetkým ostatným prvkom."), ""),
                Word_DB("Najväčší", Difficulty.EASY, listOf("Найбільший"), listOf("Najväčší prvok v čiastočne usporiadanej množine je prvok, ktorý je väčší alebo rovný všetkým ostatným prvkom."), ""),
                Word_DB("Najväčší spoločný deliteľ", Difficulty.MEDIUM, listOf("Найбільший спільний дільник"), listOf("Najväčší spoločný deliteľ dvoch čísel je najväčšie číslo, ktoré obe čísla delí bezo zvyšku."), "https://uk.wikipedia.org/wiki/%D0%9D%D0%B0%D0%B9%D0%B1%D1%96%D0%BB%D1%8C%D1%88%D0%B8%D0%B9_%D1%81%D0%BF%D1%96%D0%BB%D1%8C%D0%BD%D0%B8%D0%B9_%D0%B4%D1%96%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA"),
                Word_DB("Násobenie", Difficulty.HARD, listOf("Множення"), listOf("Násobenie je binárna operácia, ktorá spája dve čísla a dáva výsledný súčin."), "https://uk.wikipedia.org/wiki/%D0%9C%D0%BD%D0%BE%D0%B6%D0%B5%D0%BD%D0%BD%D1%8F"),
                Word_DB("Násobenie matíc", Difficulty.MEDIUM, listOf("Множення матриць"), listOf("Násobenie matíc je operácia, ktorá kombinuje dve matice za účelom získania novej matice podľa pravidiel pre súčin riadkov a stĺpcov."), ""),
                Word_DB("Negácia", Difficulty.HARD, listOf("Заперечення"), listOf("Negácia výrazu je logická operácia, ktorá mení jeho pravdivostnú hodnotu."), "https://uk.wikipedia.org/wiki/%D0%97%D0%B0%D0%BF%D0%B5%D1%80%D0%B5%D1%87%D0%B5%D0%BD%D0%BD%D1%8F"),
                Word_DB("Nekonečne veľa riešení", Difficulty.MEDIUM, listOf("Нескінченно багато рішень"), listOf("Nekonečne veľa riešení znamená, že sústava rovníc má nekonečný počet riešení."), ""),
                Word_DB("Neobjavený", Difficulty.MEDIUM, listOf("Не відкритий"), listOf("Neobjavený uzol v algoritme prehľadávania grafu znamená, že ešte nebol navštívený."), ""),
                Word_DB("Nepriama úmera", Difficulty.HARD, listOf("Обернена пропорційність"), listOf("Nepriama úmera nastáva, keď zvýšenie jednej veličiny vedie k zníženiu druhej."), ""),
                Word_DB("Nezávislosť", Difficulty.MEDIUM, listOf("Незалежність"), listOf("Nezávislosť dvoch udalostí znamená, že výskyt jednej nemá vplyv na výskyt druhej."), ""),

                Word_DB("Obdĺžnik", Difficulty.HARD, listOf("Прямокутник"), listOf("Obdĺžnik je štvorec so všetkými uhlami pravými, ale s rôznou dĺžkou strán."), "https://uk.wikipedia.org/wiki/%D0%9F%D1%80%D1%8F%D0%BC%D0%BE%D0%BA%D1%83%D1%82%D0%BD%D0%B8%D0%BA"),
                Word_DB("Objavený", Difficulty.MEDIUM, listOf("Відкритий"), listOf("Objavený uzol v grafe znamená, že bol navštívený a preskúmaný."), ""),
                Word_DB("Objem", Difficulty.EASY, listOf("Об'єм"), listOf("Objem telesa je priestor, ktorý toto teleso zaberá."), "https://uk.wikipedia.org/wiki/%D0%9E%D0%B1%27%D1%94%D0%BC"),
                Word_DB("Obsah", Difficulty.MEDIUM, listOf("Площа"), listOf("Obsah rovinného útvaru je plocha, ktorú tento útvar ohraničuje."), "https://uk.wikipedia.org/wiki/%D0%9F%D0%BB%D0%BE%D1%89%D0%B0"),
                Word_DB("Obvod", Difficulty.MEDIUM, listOf("Окружність"), listOf("Obvod geometrického útvaru je súčet dĺžok všetkých jeho strán."), ""),
                Word_DB("Odhad", Difficulty.HARD, listOf("Приблизна оцінка", "оцінка"), listOf("Odhad je približná hodnota alebo výsledok, ktorý nie je presne vypočítaný, ale približuje sa reálnemu číslu."), ""),
                Word_DB("Odpoveď", Difficulty.EASY, listOf("Відповідь"), listOf("Odpoveď na problém môže byť vyjadrená matematickým výsledkom alebo riešením."), ""),
                Word_DB("Odstrániť", Difficulty.EASY, listOf("Усунути", "ліквідувати"), listOf("Odstrániť znamená v matematických operáciách eliminovať prvky z množiny alebo grafu."), ""),
                Word_DB("Okrúhle zátvorky", Difficulty.MEDIUM, listOf("Круглі дужки"), listOf("Okrúhle zátvorky sa používajú pri písaní algebraických výpočtov a určujú poradie operácií."), ""),
                Word_DB("Orientovaný graf", Difficulty.EASY, listOf("Орієнтований граф"), listOf("Orientovaný graf je graf, v ktorom sú hrany usporiadané a majú smer."), "https://uk.wikipedia.org/wiki/%D0%9E%D1%80%D1%96%D1%94%D0%BD%D1%82%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B9_%D0%B3%D1%80%D0%B0%D1%84"),
                Word_DB("Osemsten", Difficulty.MEDIUM, listOf("Октаедр", "восьмигранник"), listOf("Osemsten je polyeder, ktorý má osem rovinných strán."), "https://uk.wikipedia.org/wiki/%D0%9E%D0%BA%D1%82%D0%B0%D0%B5%D0%B4%D1%80"),
                Word_DB("Otočenie", Difficulty.HARD, listOf("Поворот"), listOf("Otočenie je transformácia, ktorá mení polohu útvaru bez zmeny jeho tvaru alebo veľkosti."), ""),

                Word_DB("Parita", Difficulty.MEDIUM, listOf("Парність"), listOf("Parita označuje, či je číslo párne alebo nepárne."), ""),
                Word_DB("Párny graf", Difficulty.HARD, listOf("Двочастковий граф"), listOf("Párny graf je graf, kde každý vrchol má párny stupeň."), "https://uk.wikipedia.org/wiki/%D0%94%D0%B2%D0%BE%D1%87%D0%B0%D1%81%D1%82%D0%BA%D0%BE%D0%B2%D0%B8%D0%B9_%D0%B3%D1%80%D0%B0%D1%84"),
                Word_DB("Pascalov trojuholník", Difficulty.EASY, listOf("Трикутник Паскаля"), listOf("Pascalov trojuholník je trojuholníkové usporiadanie binomických koeficientov, ktoré sa používa v kombinatorike."), "https://uk.wikipedia.org/wiki/%D0%A2%D1%80%D0%B8%D0%BA%D1%83%D1%82%D0%BD%D0%B8%D0%BA_%D0%9F%D0%B0%D1%81%D0%BA%D0%B0%D0%BB%D1%8F"),
                Word_DB("Permutácia", Difficulty.HARD, listOf("Перестановка"), listOf("Permutácia je usporiadaná postupnosť prvkov z určitej množiny."), "https://uk.wikipedia.org/wiki/%D0%9F%D0%B5%D1%80%D0%B5%D1%81%D1%82%D0%B0%D0%BD%D0%BE%D0%B2%D0%BA%D0%B0"),
                Word_DB("Petersenov graf", Difficulty.EASY, listOf("Граф Петерсена"), listOf("Petersenov graf je špeciálny, symetrický a trojuholníkový graf používaný v teórii grafov."), "https://uk.wikipedia.org/wiki/%D0%93%D1%80%D0%B0%D1%84_%D0%9F%D0%B5%D1%82%D0%B5%D1%80%D1%81%D0%B5%D0%BD%D0%B0"),
                Word_DB("Platnosť", Difficulty.MEDIUM, listOf("Дія", "чинність", "термін дії"), listOf("Platnosť výrazu je určená, ak sa jedná o pravdivý alebo nepravdivý výrok."), ""),
                Word_DB("Platónske teleso", Difficulty.HARD, listOf("Правильний многогранник"), listOf("Platónske teleso je pravidelné mnohosten, ktorý má všetky strany rovnaké a všetky vrcholy rovnako usporiadané."), "https://uk.wikipedia.org/wiki/%D0%9F%D1%80%D0%B0%D0%B2%D0%B8%D0%BB%D1%8C%D0%BD%D0%B8%D0%B9_%D0%BC%D0%BD%D0%BE%D0%B3%D0%BE%D0%B3%D1%80%D0%B0%D0%BD%D0%BD%D0%B8%D0%BA"),
                Word_DB("Plocha", Difficulty.MEDIUM, listOf("Поверхня", "площа"), listOf("Plocha geometrického útvaru je oblasť, ktorú tento útvar pokrýva v rovine."), ""),
                Word_DB("P-NP problém", Difficulty.EASY, listOf("Рівність класів P і NP"), listOf("P-NP problém je otvorený problém v informatike a matematike, ktorý skúma rozdiel medzi problémami, ktoré môžeme efektívne vyriešiť a tými, ktoré môžeme efektívne overiť."), "https://uk.wikipedia.org/wiki/%D0%A0%D1%96%D0%B2%D0%BD%D1%96%D1%81%D1%82%D1%8C_%D0%BA%D0%BB%D0%B0%D1%81%D1%96%D0%B2_P_%D1%96_NP"),
                Word_DB("Počet", Difficulty.MEDIUM, listOf("Кількість"), listOf("Počet prvkov v množine určuje jej veľkosť alebo kardinálnosť."), ""),
                Word_DB("Podgraf", Difficulty.EASY, listOf("Підграф"), listOf("Podgraf je graf, ktorý je čiastočnou štruktúrou pôvodného grafu, obsahujúc časť jeho vrcholov a hrán."), ""),
                Word_DB("Podmienka", Difficulty.HARD, listOf("Умова"), listOf("Podmienka určuje, či sa nejaká operácia alebo výrok vykoná na základe logického testu."), ""),
                Word_DB("Podmnožina", Difficulty.EASY, listOf("Підмножина"), listOf("Podmnožina je množina, ktorá obsahuje iba prvky z inej množiny, z ktorej je odvodená."), "https://uk.wikipedia.org/wiki/%D0%9F%D1%96%D0%B4%D0%BC%D0%BD%D0%BE%D0%B6%D0%B8%D0%BD%D0%B0"),
                Word_DB("Pole", Difficulty.EASY, listOf("Поле"), listOf("Pole v algebre je množina s dvoma operáciami, kde každá nejaká operácia má svoje inverzné prvky okrem nuly."), "https://uk.wikipedia.org/wiki/%D0%9F%D0%BE%D0%BB%D0%B5_(%D0%B0%D0%BB%D0%B3%D0%B5%D0%B1%D1%80%D0%B0)"),
                Word_DB("Pologrupa", Difficulty.EASY, listOf("Напівгрупа"), listOf("Pologrupa je algebraická štruktúra s jednou binárnou operáciou, ktorá je uzavretá a asociatívna."), "https://uk.wikipedia.org/wiki/%D0%9D%D0%B0%D0%BF%D1%96%D0%B2%D0%B3%D1%80%D1%83%D0%BF%D0%B0"),
                Word_DB("Polomer", Difficulty.HARD, listOf("Радіус"), listOf("Polomer je vzdialenosť od stredu kruhu alebo gule k jeho obvodu alebo povrchu."), "https://uk.wikipedia.org/wiki/%D0%A0%D0%B0%D0%B4%D1%96%D1%83%D1%81"),
                Word_DB("Polynóm", Difficulty.EASY, listOf("Поліном"), listOf("Polynóm je algebraický výraz obsahujúci premenné a koeficienty s operáciami sčítania, násobenia a umocňovania."), ""),
                Word_DB("Poradie", Difficulty.EASY, listOf("Порядок"), listOf("Poradie prvkov v množine alebo postupnosti je ich usporiadanie podľa určitej vlastnosti alebo pravidla."), ""),
                Word_DB("Porovnateľný", Difficulty.EASY, listOf("Порівнянний"), listOf("Porovnateľný znamená, že dva prvky z množiny môžu byť vzájomne usporiadané podľa určitého vzťahu."), ""),
                Word_DB("Postupnosť", Difficulty.MEDIUM, listOf("Послідовність"), listOf("Postupnosť je usporiadaný zoznam prvkov, kde poradie hrá úlohu."), ""),
                Word_DB("Posunúť", Difficulty.EASY, listOf("Зсунути", "посунути"), listOf("Posunúť znamená v matematike zmeniť polohu objektu bez jeho deformácie."), ""),
                Word_DB("Potenčná množina", Difficulty.HARD, listOf("Булеан"), listOf("Potenčná množina je množina všetkých podmnožín danej množiny."), "https://uk.wikipedia.org/wiki/%D0%91%D1%83%D0%BB%D0%B5%D0%B0%D0%BD"),
                Word_DB("Pôvodná matica", Difficulty.MEDIUM, listOf("Початкова матриця"), listOf("Pôvodná matica je matica pred aplikovaním transformácie, napríklad transpozície alebo inverzie."), ""),
                Word_DB("Pravidelný graf", Difficulty.HARD, listOf("Регулярний граф"), listOf("Pravidelný graf je graf, v ktorom majú všetky vrcholy rovnaký stupeň."), "https://uk.wikipedia.org/wiki/%D0%A0%D0%B5%D0%B3%D1%83%D0%BB%D1%8F%D1%80%D0%BD%D0%B8%D0%B9_%D0%B3%D1%80%D0%B0%D1%84"),
                Word_DB("Pravítko", Difficulty.HARD, listOf("Лінійка"), listOf("Pravítko sa používa v geometrii na kreslenie priamok a meranie dĺžok."), ""),
                Word_DB("Prehľadávanie do hĺbky", Difficulty.EASY, listOf("Пошук у глибину"), listOf("Prehľadávanie do hĺbky je algoritmus na prechádzanie alebo vyhľadávanie v grafe alebo strome, kde sa prechádza po jednom vetve až k jej koncu."), "https://uk.wikipedia.org/wiki/%D0%9F%D0%BE%D1%88%D1%83%D0%BA_%D1%83_%D0%B3%D0%BB%D0%B8%D0%B1%D0%B8%D0%BD%D1%83"),
                Word_DB("Prehľadávanie do šírky", Difficulty.EASY, listOf("Пошук у ширину"), listOf("Prehľadávanie do šírky je algoritmus, ktorý prehľadáva graf alebo strom úrovňovo, teda od vrcholu k jeho susedom."), "https://uk.wikipedia.org/wiki/%D0%9F%D0%BE%D1%88%D1%83%D0%BA_%D1%83_%D1%88%D0%B8%D1%80%D0%B8%D0%BD%D1%83"),
                Word_DB("Premenná", Difficulty.MEDIUM, listOf("Змінна"), listOf("Premenná je symbol, ktorý zastupuje neznámu alebo meniteľnú hodnotu v rovnici alebo výraze."), "https://uk.wikipedia.org/wiki/%D0%97%D0%BC%D1%96%D0%BD%D0%BD%D0%B0"),
                Word_DB("Preskúmať", Difficulty.HARD, listOf("Перевірити", "дослідити"), listOf("Preskúmať znamená prejsť všetky možnosti alebo objekty, aby sa našli riešenia alebo vlastnosti."), ""),
                Word_DB("Priamka", Difficulty.MEDIUM, listOf("Пряма", "лінія"), listOf("Priamka je geometrický útvar definovaný ako nekonečne dlhá priama čiara bez zakrivenia."), ""),
                Word_DB("Priebežný test", Difficulty.MEDIUM, listOf("Проміжний тест"), listOf("Priebežný test slúži na hodnotenie aktuálnych vedomostí alebo pokroku počas procesu učenia alebo výskumu."), ""),
                Word_DB("Priemer", Difficulty.HARD, listOf("Діаметр"), listOf("Priemer je súčet všetkých hodnôt v množine delený počtom týchto hodnôt, teda aritmetický priemer."), "https://uk.wikipedia.org/wiki/%D0%94%D1%96%D0%B0%D0%BC%D0%B5%D1%82%D1%80"),
                Word_DB("Prienik", Difficulty.HARD, listOf("Перетин множин"), listOf("Prienik množín je množina prvkov, ktoré patria do všetkých z daných množín."), "https://uk.wikipedia.org/wiki/%D0%9F%D0%B5%D1%80%D0%B5%D1%82%D0%B8%D0%BD_%D0%BC%D0%BD%D0%BE%D0%B6%D0%B8%D0%BD"),
                Word_DB("Priesečník", Difficulty.HARD, listOf("Перетин"), listOf("Priesečník je bod, kde sa pretínajú dve priamky alebo krivky."), ""),
                Word_DB("Princíp zapojenia a vypojenia", Difficulty.MEDIUM, listOf("Формула включень-виключень"), listOf("Princíp zapojenia a vypojenia je technika v kombinatorike používaná na počítanie veľkosti zjednotenia množín."), "https://uk.wikipedia.org/wiki/%D0%A4%D0%BE%D1%80%D0%BC%D1%83%D0%BB%D0%B0_%D0%B2%D0%BA%D0%BB%D1%8E%D1%87%D0%B5%D0%BD%D1%8C-%D0%B2%D0%B8%D0%BA%D0%BB%D1%8E%D1%87%D0%B5%D0%BD%D1%8C"),
                Word_DB("Pripočítanie", Difficulty.MEDIUM, listOf("Додавання"), listOf("Pripočítanie znamená pridanie jednej hodnoty k druhej."), ""),
                Word_DB("Pripočítanie násobku", Difficulty.HARD, listOf("Додавання кратного"), listOf("Pripočítanie násobku znamená pridať násobok jednej hodnoty k inej hodnote v lineárnej kombinácii."), ""),
                Word_DB("Priradiť", Difficulty.HARD, listOf("Врахувати"), listOf("Priradiť znamená priradiť určitý prvok alebo hodnotu inému prvku, často pomocou funkcie alebo mapovania."), ""),
                Word_DB("Prirodzené číslo", Difficulty.MEDIUM, listOf("Натуральне число"), listOf("Prirodzené číslo je kladné celé číslo, ktoré sa používa na počítanie."), "https://uk.wikipedia.org/wiki/%D0%9D%D0%B0%D1%82%D1%83%D1%80%D0%B0%D0%BB%D1%8C%D0%BD%D0%B5_%D1%87%D0%B8%D1%81%D0%BB%D0%BE"),
                Word_DB("Prosté zobrazenie", Difficulty.HARD, listOf("Ін'єкція"), listOf("Prosté zobrazenie je zobrazenie, kde každý prvok v obore hodnôt má práve jedného predošlého prvku z oboru definície."), "https://uk.wikipedia.org/wiki/%D0%86%D0%BD%27%D1%94%D0%BA%D1%86%D1%96%D1%8F_(%D0%BC%D0%B0%D1%82%D0%B5%D0%BC%D0%B0%D1%82%D0%B8%D0%BA%D0%B0)"),
                Word_DB("Prvočíslo", Difficulty.MEDIUM, listOf("Просте число"), listOf("Prvočíslo je číslo, ktoré má presne dva delitele, jedničku a samé seba."), "https://uk.wikipedia.org/wiki/%D0%9F%D1%80%D0%BE%D1%81%D1%82%D0%B5_%D1%87%D0%B8%D1%81%D0%BB%D0%BE"),
                Word_DB("Prvok", Difficulty.HARD, listOf("Елемент"), listOf(""), "Prvok je jednotlivý objekt, ktorý patrí do určitej množiny."),

                Word_DB("Racionálne číslo", Difficulty.EASY, listOf("Раціональне число"), listOf("Racionálne číslo je číslo, ktoré možno vyjadriť ako podiel dvoch celých čísel."), "https://uk.wikipedia.org/wiki/%D0%A0%D0%B0%D1%86%D1%96%D0%BE%D0%BD%D0%B0%D0%BB%D1%8C%D0%BD%D0%B5_%D1%87%D0%B8%D1%81%D0%BB%D0%BE"),
                Word_DB("Rád grafu", Difficulty.MEDIUM, listOf("Порядок графа"), listOf("Rád grafu označuje počet vrcholov v grafe."), ""),
                Word_DB("Rad", Difficulty.EASY, listOf("Ряд"), listOf("Rad je usporiadaná postupnosť čísel, ktorá sa riadi určitým pravidlom."), "https://uk.wikipedia.org/wiki/%D0%A0%D1%8F%D0%B4_(%D0%BC%D0%B0%D1%82%D0%B5%D0%BC%D0%B0%D1%82%D0%B8%D0%BA%D0%B0)"),
                Word_DB("Reflexívna relácia", Difficulty.MEDIUM, listOf("Рефлексивне відношення"), listOf("Reflexívna relácia je relácia, kde každý prvok je v relácii sám so sebou."), "https://uk.wikipedia.org/wiki/%D0%A0%D0%B5%D1%84%D0%BB%D0%B5%D0%BA%D1%81%D0%B8%D0%B2%D0%BD%D0%B5_%D0%B2%D1%96%D0%B4%D0%BD%D0%BE%D1%88%D0%B5%D0%BD%D0%BD%D1%8F"),
                Word_DB("Regulárna gramatika", Difficulty.EASY, listOf("Регулярна граматика"), listOf("Regulárna gramatika je forma gramatiky v teórii formálnych jazykov, ktorá je obmedzená určitými pravidlami."), "https://uk.wikipedia.org/wiki/%D0%A0%D0%B5%D0%B3%D1%83%D0%BB%D1%8F%D1%80%D0%BD%D0%B0_%D0%B3%D1%80%D0%B0%D0%BC%D0%B0%D1%82%D0%B8%D0%BA%D0%B0"),
                Word_DB("Regulárna matica", Difficulty.HARD, listOf("Невироджена матриця"), listOf("Regulárna matica je matica, ktorá má inverznú maticu."), "https://uk.wikipedia.org/wiki/%D0%9D%D0%B5%D0%B2%D0%B8%D1%80%D0%BE%D0%B4%D0%B6%D0%B5%D0%BD%D0%B0_%D0%BC%D0%B0%D1%82%D1%80%D0%B8%D1%86%D1%8F"),
                Word_DB("Rekurentná rovnica", Difficulty.MEDIUM, listOf("Рекурентне рівняння"), listOf("Rekurentná rovnica je rovnica, ktorá vyjadruje hodnotu členov postupnosti na základe predošlých členov."), ""),
                Word_DB("Rekurentný vzťah", Difficulty.MEDIUM, listOf("Рекурентне співвідношення"), listOf("Rekurentný vzťah je vzťah medzi členmi postupnosti, ktorý definuje každý člen v závislosti na predošlých členoch."), "https://uk.wikipedia.org/wiki/%D0%A0%D0%B5%D0%BA%D1%83%D1%80%D0%B5%D0%BD%D1%82%D0%BD%D0%B5_%D1%81%D0%BF%D1%96%D0%B2%D0%B2%D1%96%D0%B4%D0%BD%D0%BE%D1%88%D0%B5%D0%BD%D0%BD%D1%8F"),
                Word_DB("Relácia", Difficulty.HARD, listOf("Відношення"), listOf("Relácia je množina usporiadaných dvojíc, ktoré vyjadrujú vzťah medzi prvkami dvoch množín."), "https://uk.wikipedia.org/wiki/%D0%92%D1%96%D0%B4%D0%BD%D0%BE%D1%88%D0%B5%D0%BD%D0%BD%D1%8F"),
                Word_DB("Reťazec", Difficulty.HARD, listOf("Послідовність"), listOf("Reťazec je sekvencia znakov, zvyčajne používaná v programovaní na reprezentáciu textu."), ""),
                Word_DB("Riadok", Difficulty.EASY, listOf("Рядок"), listOf("Riadok je horizontálna sekvencia prvkov alebo hodnôt v tabuľke alebo matici."), ""),
                Word_DB("Rotácia", Difficulty.MEDIUM, listOf("Обертання"), listOf("Rotácia je otočenie objektu okolo určitého bodu alebo osi."), ""),
                Word_DB("Rovina", Difficulty.MEDIUM, listOf("Рівнина", "площина"), listOf("Rovina je dvojrozmerný geometrický priestor, v ktorom sa nachádzajú body, priamky a krivky."), ""),
                Word_DB("Rovinný graf\n (Planárny graf)", Difficulty.EASY, listOf("Планарний граф"), listOf("Rovinný graf (Planárny graf) je graf, ktorý je možné nakresliť na rovinu bez toho, aby sa jeho hrany pretínali."), "https://uk.wikipedia.org/wiki/%D0%9F%D0%BB%D0%B0%D0%BD%D0%B0%D1%80%D0%BD%D0%B8%D0%B9_%D0%B3%D1%80%D0%B0%D1%84"),
                Word_DB("Rovnaký", Difficulty.MEDIUM, listOf("Однаковий"), listOf("Rovnaký znamená, že dva objekty alebo hodnoty sú identické alebo ekvivalentné."), ""),
                Word_DB("Rovnica", Difficulty.MEDIUM, listOf("Рівняння"), listOf("Rovnica je matematické tvrdenie, ktoré uvádza rovnosť dvoch výrazov."), "https://uk.wikipedia.org/wiki/%D0%A0%D1%96%D0%B2%D0%BD%D1%8F%D0%BD%D0%BD%D1%8F"),
                Word_DB("Rovnosť", Difficulty.EASY, listOf("Рівність"), listOf("Rovnosť je vzťah medzi dvoma výrazmi, ktoré majú rovnakú hodnotu."), ""),
                Word_DB("Rozdiel", Difficulty.EASY, listOf("Різниця"), listOf("Rozdiel množín je množina prvkov, ktoré patria do jednej množiny, ale nie do druhej."), "https://uk.wikipedia.org/wiki/%D0%A0%D1%96%D0%B7%D0%BD%D0%B8%D1%86%D1%8F"),

                Word_DB("Sčítanie", Difficulty.MEDIUM, listOf("Додавання"), listOf("Sčítanie je aritmetická operácia, ktorá spája dve alebo viac hodnôt do jednej hodnoty."), "https://uk.wikipedia.org/wiki/%D0%94%D0%BE%D0%B4%D0%B0%D0%B2%D0%B0%D0%BD%D0%BD%D1%8F"),
                Word_DB("Sierpińského trojúhelník", Difficulty.EASY, listOf("Трикутник Серпінського"), listOf("Sierpińského trojúhelník je fraktálna geometrická štruktúra, ktorá vzniká rekurzívnym rozdeľovaním trojuholníka na menšie trojuholníky."), "https://uk.wikipedia.org/wiki/%D0%A2%D1%80%D0%B8%D0%BA%D1%83%D1%82%D0%BD%D0%B8%D0%BA_%D0%A1%D0%B5%D1%80%D0%BF%D1%96%D0%BD%D1%81%D1%8C%D0%BA%D0%BE%D0%B3%D0%BE"),
                Word_DB("Singulárna matica", Difficulty.HARD, listOf("Вироджена матриця"), listOf("Singulárna matica je matica, ktorá nemá inverznú maticu, teda jej determinant je nulový."), "https://uk.wikipedia.org/wiki/%D0%92%D0%B8%D1%80%D0%BE%D0%B4%D0%B6%D0%B5%D0%BD%D0%B0_%D0%BC%D0%B0%D1%82%D1%80%D0%B8%D1%86%D1%8F"),
                Word_DB("Sled", Difficulty.MEDIUM, listOf("Послідовність"), listOf("Sled v grafe je postupnosť hrán, kde každá hrana spája dva po sebe nasledujúce vrcholy."), ""),
                Word_DB("Složené(Kľúčové) zátvorky", Difficulty.HARD, listOf("Фігурні дужки"), listOf("Složené(Kľúčové) zátvorky sa používajú na ohraničenie blokov kódu alebo výrazu."), ""),
                Word_DB("Slučka", Difficulty.HARD, listOf("Петля"), listOf("Slučka je hrana v grafe, ktorá spája vrchol s ním samým."), ""),
                Word_DB("Spektrálna analýza", Difficulty.EASY, listOf("Спектральний аналіз"), listOf("Spektrálna analýza je matematická metóda skúmania vlastností matíc prostredníctvom ich vlastných čísel a vektorov."), "https://uk.wikipedia.org/wiki/%D0%A1%D0%BF%D0%B5%D0%BA%D1%82%D1%80%D0%B0%D0%BB%D1%8C%D0%BD%D0%B8%D0%B9_%D0%B0%D0%BD%D0%B0%D0%BB%D1%96%D0%B7"),
                Word_DB("Spojiť", Difficulty.MEDIUM, listOf("З'єднати", "зв'язати"), listOf("Spojiť znamená zlúčiť dva alebo viac objektov alebo množín do jedného celku."), ""),
                Word_DB("Spojnica", Difficulty.HARD, listOf("Сполучна лінія"), listOf("Spojnica je hrana, ktorá spája dva vrcholy v grafe."), ""),
                Word_DB("Stĺpec", Difficulty.EASY, listOf("Стовпець"), listOf("Stĺpec je vertikálna sekvencia prvkov alebo hodnôt v tabuľke alebo matici."), ""),
                Word_DB("Stopa", Difficulty.MEDIUM, listOf("Слід"), listOf("Stopa matice je súčet prvkov na jej hlavnej diagonále."), ""),
                Word_DB("Strom", Difficulty.MEDIUM, listOf("Дерево"), listOf("Strom je acyklický graf, v ktorom každý vrchol je spojený s inými vrcholmi cestou, pričom neexistujú cykly."), "https://uk.wikipedia.org/wiki/%D0%94%D0%B5%D1%80%D0%B5%D0%B2%D0%BE_(%D1%82%D0%B5%D0%BE%D1%80%D1%96%D1%8F_%D0%B3%D1%80%D0%B0%D1%84%D1%96%D0%B2)"),
                Word_DB("Stupeň vrcholu", Difficulty.EASY, listOf("Степінь вершини"), listOf("Stupeň vrcholu je počet hrán pripojených k vrcholu v grafe."), "https://uk.wikipedia.org/wiki/%D0%A1%D1%82%D0%B5%D0%BF%D1%96%D0%BD%D1%8C_%D0%B2%D0%B5%D1%80%D1%88%D0%B8%D0%BD%D0%B8_(%D1%82%D0%B5%D0%BE%D1%80%D1%96%D1%8F_%D0%B3%D1%80%D0%B0%D1%84%D1%96%D0%B2)"),
                Word_DB("Stupnica", Difficulty.MEDIUM, listOf("Шкала"), listOf("Stupnica je usporiadaná postupnosť hodnôt, často používaná na meranie alebo porovnanie."), ""),
                Word_DB("Štvorec", Difficulty.MEDIUM, listOf("Квадрат"), listOf("Štvorec je štvorec s rovnakými dĺžkami strán a pravými uhlami."), "https://uk.wikipedia.org/wiki/%D0%9A%D0%B2%D0%B0%D0%B4%D1%80%D0%B0%D1%82"),
                Word_DB("Štvorsten", Difficulty.EASY, listOf("Чотиригранник"), listOf("Štvorsten je trojrozmerný útvar so štyrmi trojuholníkovými stenami."), "https://uk.wikipedia.org/wiki/%D0%A7%D0%BE%D1%82%D0%B8%D1%80%D0%B8%D0%B3%D1%80%D0%B0%D0%BD%D0%BD%D0%B8%D0%BA"),
                Word_DB("Substitúcia", Difficulty.EASY, listOf("Субституція"), listOf("Substitúcia je proces nahrádzania jednej premenej alebo výrazu iným."), ""),
                Word_DB("Súčet", Difficulty.HARD, listOf("Сума"), listOf("Súčet je výsledok operácie sčítania dvoch alebo viacerých čísel."), ""),
                Word_DB("Súčin", Difficulty.HARD, listOf("Добуток"), listOf("Súčin je výsledok násobenia dvoch alebo viacerých čísel alebo výrazov."), ""),
                Word_DB("Surjekcia", Difficulty.EASY, listOf("Сюр'єкція"), listOf("Surjekcia je funkcia, kde každý prvok v množine obrazov má aspoň jeden vzor v množine definície."), "https://uk.wikipedia.org/wiki/%D0%A1%D1%8E%D1%80%27%D1%94%D0%BA%D1%86%D1%96%D1%8F"),
                Word_DB("Sused", Difficulty.EASY, listOf("Сусід"), listOf("Sused vrcholu v grafe je vrchol, ktorý je pripojený k danému vrcholu hranou."), ""),
                Word_DB("Sústava", Difficulty.HARD, listOf("Система"), listOf("Sústava je súbor rovníc alebo iných vzťahov, ktoré je potrebné spoločne vyriešiť."), ""),
                Word_DB("Sústava rovníc", Difficulty.MEDIUM, listOf("Система рівнянь"), listOf("Sústava rovníc je sada dvoch alebo viacerých rovníc, ktoré obsahujú rovnaké neznáme a ktoré sa riešia súčasne."), "https://uk.wikipedia.org/wiki/%D0%A1%D0%B8%D1%81%D1%82%D0%B5%D0%BC%D0%B0_%D1%80%D1%96%D0%B2%D0%BD%D1%8F%D0%BD%D1%8C"),
                Word_DB("Súvislosť", Difficulty.HARD, listOf("Зв'язність"), listOf("Súvislosť v grafe znamená, že medzi každými dvoma vrcholmi existuje cesta."), ""),
                Word_DB("Súvislý graf", Difficulty.MEDIUM, listOf("Зв'язний граф"), listOf("Súvislý graf je graf, v ktorom je každý vrchol priamo alebo nepriamo spojený s každým iným vrcholom."), "https://uk.wikipedia.org/wiki/%D0%97%D0%B2%27%D1%8F%D0%B7%D0%BD%D0%B8%D0%B9_%D0%B3%D1%80%D0%B0%D1%84"),
                Word_DB("Symetrická grupa", Difficulty.EASY, listOf("Симетрична група"), listOf("Symetrická grupa je grupa, ktorá obsahuje všetky permutácie množiny."), "https://uk.wikipedia.org/wiki/%D0%A1%D0%B8%D0%BC%D0%B5%D1%82%D1%80%D0%B8%D1%87%D0%BD%D0%B0_%D0%B3%D1%80%D1%83%D0%BF%D0%B0"),
                Word_DB("Symetrická relácia", Difficulty.MEDIUM, listOf("Симетричне відношення"), listOf("Symetrická relácia je relácia, v ktorej ak a súvisí s b, potom aj b súvisí s a."), "https://uk.wikipedia.org/wiki/%D0%A1%D0%B8%D0%BC%D0%B5%D1%82%D1%80%D0%B8%D1%87%D0%BD%D0%B5_%D0%B2%D1%96%D0%B4%D0%BD%D0%BE%D1%88%D0%B5%D0%BD%D0%BD%D1%8F"),

                Word_DB("Ťah", Difficulty.MEDIUM, listOf("Хід"), listOf("Ťah v grafe je cesta, ktorá nepoužíva žiadnu hranu viac ako raz."), ""),
                Word_DB("Teória čísel", Difficulty.EASY, listOf("Теорія чисел"), listOf("Teória čísel je oblasť matematiky, ktorá sa zaoberá vlastnosťami a vzťahmi medzi celými číslami."), "https://uk.wikipedia.org/wiki/%D0%A2%D0%B5%D0%BE%D1%80%D1%96%D1%8F_%D1%87%D0%B8%D1%81%D0%B5%D0%BB"),
                Word_DB("Teória grafov", Difficulty.EASY, listOf("Теорія графів"), listOf("Teória grafov je matematická oblasť skúmajúca vlastnosti grafov a ich aplikácie."), "https://uk.wikipedia.org/wiki/%D0%A2%D0%B5%D0%BE%D1%80%D1%96%D1%8F_%D0%B3%D1%80%D0%B0%D1%84%D1%96%D0%B2"),
                Word_DB("Toky", Difficulty.MEDIUM, listOf("Потоки"), listOf("Toky v grafe predstavujú prúdenie množstva niečoho cez grafové hrany medzi vrcholmi."), ""),
                Word_DB("Torus", Difficulty.EASY, listOf("Тор"), listOf("Torus je geometrický útvar tvaru prstenca alebo povrchu koblihy."), "https://uk.wikipedia.org/wiki/%D0%A2%D0%BE%D1%80_(%D0%B3%D0%B5%D0%BE%D0%BC%D0%B5%D1%82%D1%80%D1%96%D1%8F)"),
                Word_DB("Transponovaná matica", Difficulty.EASY, listOf("Транспонована матриця"), listOf("Transponovaná matica je matica, ktorá sa získava výmenou riadkov za stĺpce."), "https://uk.wikipedia.org/wiki/%D0%A2%D1%80%D0%B0%D0%BD%D1%81%D0%BF%D0%BE%D0%BD%D0%BE%D0%B2%D0%B0%D0%BD%D0%B0_%D0%BC%D0%B0%D1%82%D1%80%D0%B8%D1%86%D1%8F"),
                Word_DB("Tranzitívna relácia", Difficulty.MEDIUM, listOf("Транзитивне відношення"), listOf("Tranzitívna relácia je relácia, v ktorej platí, že ak a súvisí s b a b súvisí s c, tak aj a súvisí s c."), "https://uk.wikipedia.org/wiki/%D0%A2%D1%80%D0%B0%D0%BD%D0%B7%D0%B8%D1%82%D0%B8%D0%B2%D0%BD%D0%B5_%D0%B2%D1%96%D0%B4%D0%BD%D0%BE%D1%88%D0%B5%D0%BD%D0%BD%D1%8F"),
                Word_DB("Trisekcia uhla", Difficulty.EASY, listOf("Трисекція кута"), listOf("Trisekcia uhla je úloha rozdeliť uhol na tri rovnaké časti, čo je v prípade všeobecného uhla konštrukčne nemožné."), "https://uk.wikipedia.org/wiki/%D0%A2%D1%80%D0%B8%D1%81%D0%B5%D0%BA%D1%86%D1%96%D1%8F_%D0%BA%D1%83%D1%82%D0%B0"),
                Word_DB("Triviálny", Difficulty.EASY, listOf("Тривіальний"), listOf("Triviálny znamená jednoduchý alebo zrejmý, bez akýchkoľvek komplikácií."), ""),
                Word_DB("Trojuholník", Difficulty.EASY, listOf("Трикутник"), listOf("Trojuholník je mnohouholník s tromi stranami a tromi vnútornými uhlami."), "https://uk.wikipedia.org/wiki/%D0%A2%D1%80%D0%B8%D0%BA%D1%83%D1%82%D0%BD%D0%B8%D0%BA"),
                Word_DB("Tvrdenie", Difficulty.MEDIUM, listOf("Твердження"), listOf("Tvrdenie je matematický výrok, ktorý je potrebné dokázať alebo vyvrátiť."), ""),

                Word_DB("Úloha", Difficulty.MEDIUM, listOf("Задача", "завдання"), listOf("Úloha je úloha alebo problém, ktorý je potrebné vyriešiť alebo vyrátať."), ""),
                Word_DB("Úplný graf", Difficulty.MEDIUM, listOf("Повний граф"), listOf("Úplný graf je graf, v ktorom je každý vrchol spojený hranou s každým iným vrcholom."), "https://uk.wikipedia.org/wiki/%D0%9F%D0%BE%D0%B2%D0%BD%D0%B8%D0%B9_%D0%B3%D1%80%D0%B0%D1%84"),
                Word_DB("Určenie", Difficulty.HARD, listOf("Визначення"), listOf("Určenie je proces nájdenia riešenia alebo výsledku nejakého problému."), ""),
                Word_DB("Usporiadaná dvojica", Difficulty.MEDIUM, listOf("Впорядкована пара"), listOf("Usporiadaná dvojica je dvojica prvkov, v ktorej záleží na poradí týchto prvkov."), "https://uk.wikipedia.org/wiki/%D0%92%D0%BF%D0%BE%D1%80%D1%8F%D0%B4%D0%BA%D0%BE%D0%B2%D0%B0%D0%BD%D0%B0_%D0%BF%D0%B0%D1%80%D0%B0"),
                Word_DB("Usporiadať", Difficulty.HARD, listOf("Упорядковати"), listOf("Usporiadať znamená zoradiť objekty podľa určitého kritéria alebo pravidla."), ""),
                Word_DB("Uzavretý", Difficulty.MEDIUM, listOf("Закритий"), listOf("Uzavretý vzťah alebo množina je taký, ktorý pri určitej operácii zostáva v rámci tejto množiny."), ""),

                Word_DB("Valec", Difficulty.HARD, listOf("Циліндр"), listOf("Valec je trojrozmerný geometrický útvar s dvoma rovnobežnými kruhovými podstavami a rovnými bočnými stenami."), "https://uk.wikipedia.org/wiki/%D0%A6%D0%B8%D0%BB%D1%96%D0%BD%D0%B4%D1%80"),
                Word_DB("Variácia", Difficulty.HARD, listOf("Розміщення"), listOf("Variácia je usporiadaný výber prvkov z množiny, kde záleží na poradí."), "https://uk.wikipedia.org/wiki/%D0%A0%D0%BE%D0%B7%D0%BC%D1%96%D1%89%D0%B5%D0%BD%D0%BD%D1%8F_(%D0%BA%D0%BE%D0%BC%D0%B1%D1%96%D0%BD%D0%B0%D1%82%D0%BE%D1%80%D0%B8%D0%BA%D0%B0)"),
                Word_DB("Vlastní čísla", Difficulty.EASY, listOf("Власні значення"), listOf("Vlastní čísla sú čísla, ktoré určujú charakteristické hodnoty lineárnych operácií v matici."), "https://uk.wikipedia.org/wiki/%D0%92%D0%BB%D0%B0%D1%81%D0%BD%D1%96_%D0%B2%D0%B5%D0%BA%D1%82%D0%BE%D1%80%D0%B8_%D1%82%D0%B0_%D0%B2%D0%BB%D0%B0%D1%81%D0%BD%D1%96_%D0%B7%D0%BD%D0%B0%D1%87%D0%B5%D0%BD%D0%BD%D1%8F"),
                Word_DB("Vlastní vektory", Difficulty.EASY, listOf("Власні вектори"), listOf("Vlastní vektory sú vektory, ktoré pri pôsobení určitej transformácie menia len svoju veľkosť, nie smer."), "https://uk.wikipedia.org/wiki/%D0%92%D0%BB%D0%B0%D1%81%D0%BD%D1%96_%D0%B2%D0%B5%D0%BA%D1%82%D0%BE%D1%80%D0%B8_%D1%82%D0%B0_%D0%B2%D0%BB%D0%B0%D1%81%D0%BD%D1%96_%D0%B7%D0%BD%D0%B0%D1%87%D0%B5%D0%BD%D0%BD%D1%8F"),
                Word_DB("Vrchol", Difficulty.MEDIUM, listOf("Вершина"), listOf("Vrchol je bod v grafe, ktorý môže byť spojený s inými vrcholmi hranami."), "https://uk.wikipedia.org/wiki/%D0%92%D0%B5%D1%80%D1%88%D0%B8%D0%BD%D0%B0_(%D1%82%D0%B5%D0%BE%D1%80%D1%96%D1%8F_%D0%B3%D1%80%D0%B0%D1%84%D1%96%D0%B2)"),
                Word_DB("Výmena", Difficulty.EASY, listOf("Обмін"), listOf("Výmena znamená nahradiť jednu vec inou, zvyčajne ekvivalentnou."), ""),
                Word_DB("Výmena poradia", Difficulty.EASY, listOf("Обмін(зміна) порядку"), listOf("Výmena poradia znamená zmeniť usporiadanie prvkov podľa určitých pravidiel."), ""),
                Word_DB("Vynásobenie", Difficulty.HARD, listOf("Множення"), listOf("Vynásobenie je operácia, pri ktorej sa jedna hodnota násobí inou hodnotou."), ""),
                Word_DB("Výrok", Difficulty.HARD, listOf("Пропозиція"), listOf("Výrok je matematická veta, ktorá je buď pravdivá, alebo nepravdivá."), "https://uk.wikipedia.org/wiki/%D0%9F%D1%80%D0%BE%D0%BF%D0%BE%D0%B7%D0%B8%D1%86%D1%96%D1%8F_(%D0%BB%D0%BE%D0%B3%D1%96%D0%BA%D0%B0)"),
                Word_DB("Vyšetriť", Difficulty.HARD, listOf("Оглянути"), listOf("Vyšetriť znamená analyzovať alebo skúmať niečo s cieľom nájsť odpoveď alebo výsledok."), ""),
                Word_DB("Výskum", Difficulty.HARD, listOf("Дослідження"), listOf("Výskum je systematické hľadanie a skúmanie informácií alebo dát."), ""),
                Word_DB("Vyskytnúť sa", Difficulty.HARD, listOf("З'явитися"), listOf("Vyskytnúť sa znamená objaviť sa alebo stať sa prítomným."), ""),
                Word_DB("Vystihnúť", Difficulty.HARD, listOf("Описати"), listOf("Vystihnúť znamená presne a stručne opísať podstatu veci."), ""),
                Word_DB("Vzdialenosť", Difficulty.MEDIUM, listOf("Відстань"), listOf("Vzdialenosť je miera medzi dvoma bodmi alebo objektmi."), ""),
                Word_DB("Vzniknúť", Difficulty.EASY, listOf("Виникнути"), listOf("Vzniknúť znamená začať existovať alebo byť vytvorený."), ""),
                Word_DB("Vzorec", Difficulty.MEDIUM, listOf("Формула", "зразок"), listOf("Vzorec je matematický výraz alebo rovnice, ktorá opisuje vzťahy medzi premennými."), ""),
                Word_DB("Vzťah", Difficulty.HARD, listOf("Відношення"), listOf("Vzťah je spojenie medzi dvoma alebo viacerými objektmi alebo množinami."), ""),

                Word_DB("Zátvorka", Difficulty.MEDIUM, listOf("Дужка"), listOf("Zátvorka sa používa na označenie začiatku a konca výrazu alebo časti vety."), ""),
                Word_DB("Záverečný test", Difficulty.EASY, listOf("Фінальний тест"), listOf("Záverečný test je konečný skúšobný test z daného predmetu alebo témy."), ""),
                Word_DB("Zdvojenie kocky", Difficulty.MEDIUM, listOf("Подвоєння куба"), listOf("Zdvojenie kocky je starodávny geometrický problém, ktorý zahŕňa zdvojnásobenie objemu kocky."), "https://uk.wikipedia.org/wiki/%D0%9F%D0%BE%D0%B4%D0%B2%D0%BE%D1%94%D0%BD%D0%BD%D1%8F_%D0%BA%D1%83%D0%B1%D0%B0"),
                Word_DB("Žiadne riešenie", Difficulty.MEDIUM, listOf("Жодного рішення"), listOf("Žiadne riešenie znamená, že daná rovnica alebo úloha nemá platné riešenie."), ""),
                Word_DB("Získať", Difficulty.HARD, listOf("Добути", "отримати"), listOf("Získať znamená dostať alebo získať niečo po vykonaní určitého procesu."), ""),
                Word_DB("Zjednotenie", Difficulty.HARD, listOf("Об'єднання множин"), listOf("Zjednotenie je operácia kombinujúca prvky dvoch alebo viacerých množín do jednej množiny."), "https://uk.wikipedia.org/wiki/%D0%9E%D0%B1%27%D1%94%D0%B4%D0%BD%D0%B0%D0%BD%D0%BD%D1%8F_%D0%BC%D0%BD%D0%BE%D0%B6%D0%B8%D0%BD"),
                Word_DB("Zloženie", Difficulty.MEDIUM, listOf("Склад"), listOf("Zloženie je proces kombinovania dvoch alebo viacerých vecí dohromady."), ""),
                Word_DB("Zložitosť", Difficulty.MEDIUM, listOf("Складність"), listOf("Zložitosť sa vzťahuje na stupeň zložitosti matematického problému alebo algoritmu."), ""),
                Word_DB("Znázorniť", Difficulty.HARD, listOf("Зобразити"), listOf("Znázorniť znamená vizuálne alebo graficky predstaviť matematický koncept alebo úlohu."), ""),
                Word_DB("Zobrazenie", Difficulty.EASY, listOf("Функція (відображення, перетворення)"), listOf("Zobrazenie je matematická funkcia, ktorá priradzuje prvky z jednej množiny prvkom z druhej množiny."), "https://uk.wikipedia.org/wiki/%D0%A4%D1%83%D0%BD%D0%BA%D1%86%D1%96%D1%8F_(%D0%BC%D0%B0%D1%82%D0%B5%D0%BC%D0%B0%D1%82%D0%B8%D0%BA%D0%B0)"),
                Word_DB("Zoznam", Difficulty.MEDIUM, listOf("Список"), listOf("Zoznam je sekvencia alebo súbor prvkov zoradených podľa určitého poradia."), ""),
                Word_DB("Zväz", Difficulty.HARD, listOf("Ґратка", "порядок"), listOf("Zväz je algebraická štruktúra, ktorá spája dve operácie - supremum a infimum."), "https://uk.wikipedia.org/wiki/%D2%90%D1%80%D0%B0%D1%82%D0%BA%D0%B0_(%D0%BF%D0%BE%D1%80%D1%8F%D0%B4%D0%BE%D0%BA)")
            )
            "Matematická analýza" -> arrayOf(
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                )
            "Matematická logika I" -> arrayOf(
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                )
            "Pravdepodobnosť a štatistika" -> arrayOf(
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                Word_DB("", Difficulty.EASY, listOf(""), listOf(""), ""),
                )
            else -> arrayOf()
        }

        wordsArrayList.addAll(wordName)

        binding.wordList.isClickable = true
        val adapter = WordAdapter(requireContext(), wordsArrayList)
        binding.wordList.adapter = adapter

        binding.wordList.setOnItemClickListener { parent, view, position, id ->

            val selectedWord = wordsArrayList[position]

            val translationFragment = DetailedTranslation()

            val bundle = Bundle().apply {
                putString("wordName", selectedWord.wordName)
                putStringArrayList("translations", ArrayList(selectedWord.translations))
                putStringArrayList("exampleSentences", ArrayList(selectedWord.exampleSentences))
                putString("wordLink", selectedWord.wordLink)
            }
            translationFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(com.example.myapplication.R.id.fragment_wordpage, translationFragment)
                .addToBackStack(null)
                .commit()
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList = wordsArrayList.filter {
                    it.wordName.startsWith(newText ?: "", ignoreCase = true)
                }
                val adapter = WordAdapter(requireContext(), ArrayList(filteredList))
                binding.wordList.adapter = adapter
                return true
            }
        })

        return binding.root
    }
}