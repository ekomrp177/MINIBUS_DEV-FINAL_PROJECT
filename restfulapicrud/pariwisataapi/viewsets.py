from rest_framework import viewsets
from . import models
from . import serializers


class PariwisataViewset(viewsets.ModelViewSet):
    queryset = models.Pariwisata.objects.all()
    serializer_class = serializers.PariwisataSerializer
