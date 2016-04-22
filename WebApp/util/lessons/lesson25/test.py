# f(n) calculates nth fibonacci number

if CCStdout == None:
    # First pass
    cc = CodingCareers__()
    # Catch NameErrors in case user didn't actually define f
    try:
        cc.expect(f(0) == 0)
    except NameError:
        cc.test_fail()
    try:
        cc.expect(f(5) == 5)
    except NameError:
        cc.test_fail()
    try:
        cc.expect(f(10) == 55)
    except NameError:
        cc.test_fail()
    cc.report('pass1')
else:
    # Second pass
    cc = CodingCareers__()
    if len(CCStdout) > 0:
        # Skulpt should support re module if we want to use regexes to check
        # stdout
        cc.expect(CCStdout == 'a\nb\n')
    else:
        cc.test_fail()
    cc.report('pass2')

