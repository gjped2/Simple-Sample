
import os
import base64

print('test py')
print(base64.b64decode(os.environ.get("GH_TEST")))
print('test py')
