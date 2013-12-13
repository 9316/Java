#-------------------------------------------------
#
# Project created by QtCreator 2013-09-01T14:53:42
#
#-------------------------------------------------

QT       += core gui
QT       += sql
greaterThan(QT_MAJOR_VERSION, 4): QT += widgets

TARGET = GuiDB
TEMPLATE = app


SOURCES += main.cpp\
        mainwindow.cpp \
    authdialog.cpp

HEADERS  += mainwindow.h \
    authdialog.h

FORMS    += mainwindow.ui \
    authdialog.ui

RESOURCES += \
    icons.qrc
