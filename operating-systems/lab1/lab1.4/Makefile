CC=gcc
CFLAGS=-Werror
LIBPATH=./libhello-runtime.so
FUNCNAME=printHelloRuntime

all : hello

hello : hello.c libhello-runtime.so
	$(CC) $(CFLAGS) hello.c -o hello

libhello-runtime.so : hello-runtime.h hello-runtime.c
	$(CC) $(CFLAGS) hello-runtime.c -o libhello-runtime.so -shared

run : hello
	./hello $(LIBPATH) $(FUNCNAME)

clean : libhello-runtime.so hello
	rm -rf libhello-runtime.so hello
