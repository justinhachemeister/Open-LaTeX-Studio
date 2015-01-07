package latexstudio.editor.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import latexstudio.editor.EditorTopComponent;
import latexstudio.editor.files.FileChooserService;
import latexstudio.editor.files.FileService;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

@ActionID(
        category = "File",
        id = "latexstudio.editor.SaveFile"
)
@ActionRegistration(
        displayName = "#CTL_SaveFile"
)
@ActionReference(path = "Menu/File", position = 1300)
@Messages("CTL_SaveFile=Save File")
public final class SaveFile implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        TopComponent tc = WindowManager.getDefault().findTopComponent("EditorTopComponent");
        EditorTopComponent etc = (EditorTopComponent) tc;
        
        String content = etc.getEditorContent();
        File file = FileChooserService.getSelectedFile("tex", "TeX files", true);
        if (file != null) {
            FileService.writeToFile(file.getAbsolutePath(), content);
        }
    }
}
