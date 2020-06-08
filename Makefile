# I=10 make debug
TARG = Square
OPTS = -g

${TARG}.class: ${TARG}.java
	javac ${OPTS} $^

.PHONY: clean run debug

clean:
	${RM} ${TARG}.class
run:
	java ${TARG} ${I}
debug:
	jdb ${TARG} ${I}
