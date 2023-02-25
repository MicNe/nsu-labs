CC=gcc
CFLAGS=-Werror

all : hello

hello : hello.c libhello-shared.so
	$(CC) $(CFLAGS) hello.c -o hello -lhello-shared -L.

libhello-shared.so : hello-static.h hello-shared.c
	$(CC) $(CFLAGS) hello-shared.c -o libhello-shared.so -shared

run : hello
	LD_LIBRARY_PATH=./ ./hello

exp : hello
	export LD_LIBRARY_PATH=./

clean : libhello-shared.so hello
	rm -rf libhello-shared.so hello
