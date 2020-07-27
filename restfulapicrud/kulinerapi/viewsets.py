from rest_framework import viewsets
from . import models
from . import serializers


class KulinerViewset(viewsets.ModelViewSet):
    queryset = models.Kuliner.objects.all()
    serializer_class = serializers.KulinerSerializer
