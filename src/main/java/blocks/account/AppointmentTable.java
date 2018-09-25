package blocks.account;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

/**
 * Created by bigdrop on 9/19/2018.
 */
@Block(@FindBy(className = "appointments-table"))
public class AppointmentTable extends HtmlElement {

    @Name("ArrayList of headings in appointment table")
    @FindBys( {@FindBy(css = "table th")} )
    private List<HtmlElement> listHeadingOfAppTable;

    @Name("ArrayList of cell in appointment table")
    @FindBys( {@FindBy(css = "table td")} )
    private List<HtmlElement> listCellOfAppTable;

    public boolean getCellFromAppTable(String headingColumn, String sentence, int wordNumber) {
        int indexColumn = 0;
        for (int i = 0; i < listHeadingOfAppTable.size(); i++) {
            if(listHeadingOfAppTable.get(i).getText().equals(headingColumn)){
                indexColumn = i;
                break;
            }
        }
        for (int i = indexColumn; i < listCellOfAppTable.size(); i += listHeadingOfAppTable.size()) {
            if(listCellOfAppTable.get(i).getText().contains(returnWordInSentence(sentence, wordNumber)))
                return true;
        }
        return false;
    }

    public String returnWordInSentence(String sentence, int wordNumber) {
        if(wordNumber == 0)
            return sentence;
        String arr[] = sentence.split(" ", 10);
        String Word = arr[wordNumber - 1];
        return Word;
    }

}
