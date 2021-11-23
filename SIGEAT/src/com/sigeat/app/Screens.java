/*
 * Classe responsável pelo gerenciamento das telas do SIGEAT
 */
package com.sigeat.app;

import javax.swing.JDesktopPane;

/*
 * SIGEAT/ Application /Screens
 * @author Junior
 * Version : 1.0.0
 */
public class Screens {

    //#region - Singleton JInternalFrames
    private static FrmUsuariosCadastro cadUsuWindow = null;
    private static FrmUsuariosPesquisa pesUsuWindow = null;
    private static FrmClientesCadastro cadCliWindow = null;
    private static FrmClientesPesquisa pesCliWindow = null;
    private static FrmOS osWindow = null;

    public static void abrirUsuarioCadastroWindow(JDesktopPane desk) {
        if (cadUsuWindow == null || cadUsuWindow.isClosed()) {
            cadUsuWindow = new FrmUsuariosCadastro();
            cadUsuWindow.setVisible(true);
            desk.add(cadUsuWindow);
            desk.getDesktopManager().maximizeFrame(cadUsuWindow);
        }
    }

    public static void abrirUsuarioPesquisaWindow(JDesktopPane desk) {
        if (pesUsuWindow == null || pesUsuWindow.isClosed()) {
            pesUsuWindow = new FrmUsuariosPesquisa();
            pesUsuWindow.setVisible(true);
            desk.add(pesUsuWindow);
            desk.getDesktopManager().maximizeFrame(pesUsuWindow);
        }
    }

    public static void abrirClienteCadastroWindow(JDesktopPane desk) {
        if (cadCliWindow == null || cadCliWindow.isClosed()) {
            cadCliWindow = new FrmClientesCadastro();
            cadCliWindow.setVisible(true);
            desk.add(cadCliWindow);
            desk.getDesktopManager().maximizeFrame(cadCliWindow);
        }
    }

    public static void abrirClientePesquisaWindow(JDesktopPane desk) {
        if (pesCliWindow == null || pesCliWindow.isClosed()) {
            pesCliWindow = new FrmClientesPesquisa();
            pesCliWindow.setVisible(true);
            desk.add(pesCliWindow);
            desk.getDesktopManager().maximizeFrame(pesCliWindow);
        }
    }

    public static void abrirOSWindow(JDesktopPane desk) {
        if (osWindow == null || osWindow.isClosed()) {
            osWindow = new FrmOS();
            osWindow.setVisible(true);
            desk.add(osWindow);
            desk.getDesktopManager().maximizeFrame(osWindow);
        }
    }

    //#endregion
    public static void abrirUsuariosReport() {

        FrmUsuariosReports s = new FrmUsuariosReports(null, true);
        s.setVisible(true);

    }

    public static void abrirClientesReport() {

        FrmClientesReports s = new FrmClientesReports(null, true);
        s.setVisible(true);

    }

    public static void abrirOSReport() {

        FrmOSReports s = new FrmOSReports(null, true);
        s.setVisible(true);

    }

    public static void abrirSobre() {

        FrmSobre s = new FrmSobre(null, true);
        s.setVisible(true);

    }

}
