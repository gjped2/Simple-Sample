
import os
import base64

print(base64.b64decode(os.environ.get("GH_TEST")))
