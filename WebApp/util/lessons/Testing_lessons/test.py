# f(n) calculates nth fibonacci number

import unittest
    #def CodingCareers__EvaluateLevel():
    #cc = CodingCareers__()
    #cc.expect(f(0) == 0)
    #cc.expect(f(5) == 5)
    #cc.expect(f(10) == 55)
#cc.report()

#CodingCareers__EvaluateLevel()


#hello world
#variables
#input

def test_introlevel():
    from level1 import introLevel, level1
    import sys
    from StringIO import StringIO
    
    out = StringIO()
    sys.stdout = out
    introLevel()
    output = out.getvalue().strip()
    assert output == 'hello world!'


    out = StringIO()
    sys.stdout = out
    level1()
    output = out.getvalue().strip()
    assert output == 'april 2016' or 'April 2016'
    
test_introlevel()
