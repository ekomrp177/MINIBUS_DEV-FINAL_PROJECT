from pariwisataapi.viewsets import PariwisataViewset
from kulinerapi.viewsets import KulinerViewset
from rest_framework import routers

router = routers.DefaultRouter()
router.register('pariwisata', PariwisataViewset)
router.register('kuliner', KulinerViewset)