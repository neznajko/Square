# I=10 make debug
TARG = Square
OPTS = -g

.PHONY: clean run debug

${TARG}.class: ${TARG}.java
	javac ${OPTS} $^

clean:
	${RM} ${TARG}.class
run:
	java ${TARG} ${I}
debug:
	jdb ${TARG} ${I}
