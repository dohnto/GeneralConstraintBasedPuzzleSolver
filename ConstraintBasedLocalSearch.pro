#-------------------------------------------------
#
# Project created by QtCreator 2013-09-24T00:04:25
#
#-------------------------------------------------

QT       += core

QT       -= gui

TARGET = ConstraintBasedLocalSearch
CONFIG   += console
CONFIG   -= app_bundle

TEMPLATE = app


DESTDIR = bin
OBJECTS_DIR = bin
MOC_DIR = bin
RCC_DIR = bin
UI_DIR = bin

SOURCES += src/main.cpp \
    src/constraintbasedlocalsearch.cpp \
    src/simulatedannealing.cpp \
    src/minconflicts.cpp

HEADERS += \
    src/constraintbasedlocalsearch.h \
    src/simulatedannealing.h \
    src/minconflicts.h
